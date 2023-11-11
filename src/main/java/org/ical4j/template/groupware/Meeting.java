package org.ical4j.template.groupware;

import net.fortuna.ical4j.extensions.concept.EventType;
import net.fortuna.ical4j.extensions.property.HtmlDescription;
import net.fortuna.ical4j.model.Parameter;
import net.fortuna.ical4j.model.ParameterList;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.component.VLocation;
import net.fortuna.ical4j.model.component.VResource;
import net.fortuna.ical4j.model.parameter.CuType;
import net.fortuna.ical4j.model.parameter.PartStat;
import net.fortuna.ical4j.model.parameter.Role;
import net.fortuna.ical4j.model.parameter.Rsvp;
import net.fortuna.ical4j.model.property.Attendee;
import net.fortuna.ical4j.model.property.DtStart;
import org.ical4j.template.AbstractTemplate;

import java.net.URI;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Creates a {@link VEvent} representing a meeting of one or more attendees.
 */
public class Meeting extends AbstractTemplate<VEvent> {

    private static final List<Parameter> REQUIRED_PARAMS = Arrays.asList(CuType.INDIVIDUAL, Role.REQ_PARTICIPANT,
            PartStat.NEEDS_ACTION, Rsvp.TRUE);

    private static final List<Parameter> OPTIONAL_PARAMS = Arrays.asList(CuType.INDIVIDUAL, Role.OPT_PARTICIPANT,
            PartStat.NEEDS_ACTION);
    
    private static final List<Parameter> CHAIR_PARAMS = Arrays.asList(CuType.INDIVIDUAL, Role.CHAIR);

    private ZonedDateTime start;

    private List<URI> required = new ArrayList<>();

    private List<URI> optional = new ArrayList<>();

    private URI chair;

    private VLocation location;

    private List<VResource> resources = new ArrayList<>();

    private HtmlDescription agenda;

    public Meeting() {
        super(VEvent.class);
    }

    public Meeting(Class<VEvent> typeClass) {
        super(typeClass);
    }

    public Meeting start(ZonedDateTime start) {
        this.start = start;
        return this;
    }

    public Meeting required(URI participant) {
        required.add(participant);
        return this;
    }

    public Meeting optional(URI participant) {
        optional.add(participant);
        return this;
    }

    public Meeting chair(URI participant) {
        this.chair = participant;
        return this;
    }

    public Meeting location(VLocation location) {
        this.location = location;
        return this;
    }

    public Meeting resource(VResource resource) {
        resources.add(resource);
        return this;
    }

    public Meeting agenda(HtmlDescription agenda) {
        this.agenda = agenda;
        return this;
    }

    @Override
    public VEvent apply(VEvent vEvent) {
        vEvent.replace(EventType.MEETING);
        vEvent.replace(new DtStart<>(start));
        required.forEach(p -> vEvent.add(new Attendee(new ParameterList(REQUIRED_PARAMS), p)));
        optional.forEach(p -> vEvent.add(new Attendee(new ParameterList(OPTIONAL_PARAMS), p)));
        vEvent.add(new Attendee(new ParameterList(CHAIR_PARAMS), chair));
        if (location != null) {
            vEvent.add(location);
        }
        resources.forEach(vEvent::add);
        if (agenda != null) {
            vEvent.add(agenda);
        }
        //todo: for each existing attendee add corresponding participant component..
        return vEvent;
    }
}
