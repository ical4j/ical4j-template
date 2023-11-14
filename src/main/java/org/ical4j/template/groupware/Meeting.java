package org.ical4j.template.groupware;

import net.fortuna.ical4j.extensions.concept.EventType;
import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.ParameterList;
import net.fortuna.ical4j.model.component.*;
import net.fortuna.ical4j.model.parameter.*;
import net.fortuna.ical4j.model.property.*;
import net.fortuna.ical4j.vcard.PropertyName;
import net.fortuna.ical4j.vcard.VCard;
import net.fortuna.ical4j.vcard.property.CalAdrUri;
import net.fortuna.ical4j.vcard.property.Fn;
import org.ical4j.template.AbstractTemplate;
import org.ical4j.template.ComponentContainerSupport;
import org.ical4j.template.PropertyContainerSupport;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Creates a {@link VEvent} representing a meeting of one or more attendees.
 */
public class Meeting extends AbstractTemplate<VEvent> implements PropertyContainerSupport<VEvent>,
        ComponentContainerSupport<Component, VEvent> {

    private static final ParameterList REQUIRED_PARAMS = new ParameterList(Arrays.asList(
            CuType.INDIVIDUAL, Role.REQ_PARTICIPANT, PartStat.NEEDS_ACTION, Rsvp.TRUE));

    private static final ParameterList OPTIONAL_PARAMS = new ParameterList(Arrays.asList(
            CuType.INDIVIDUAL, Role.OPT_PARTICIPANT, PartStat.NEEDS_ACTION));
    
    private static final ParameterList CHAIR_PARAMS = new ParameterList(Arrays.asList(
            CuType.INDIVIDUAL, Role.CHAIR));


    private DtStart<?> start;

    private Duration duration;

    private Organizer organizer;

    private Uid uid;

    private Summary summary;

    private Description description;

    private Participant chair;

    private final List<Participant> required = new ArrayList<>();

    private final List<Participant> optional = new ArrayList<>();

    private VLocation location;

    private VToDo agenda;

    private VResource conference;

    private VResource recording;

    private VResource transcript;

    public Meeting() {
        super(VEvent.class);
    }

    public Meeting(Class<VEvent> typeClass) {
        super(typeClass);
    }

    public Meeting organizer(VCard card) {
        CalAdrUri uri = card.getRequiredProperty(PropertyName.CALADRURI);
        Fn name = card.getRequiredProperty(PropertyName.FN);
        this.organizer = new Organizer(new ParameterList(Collections.singletonList(new Cn(name.getValue()))),
                uri.getUri());
        return this;
    }

    public Meeting start(ZonedDateTime start) {
        this.start = new DtStart<>(start);
        return this;
    }

    public Meeting start(LocalDateTime start) {
        this.start = new DtStart<>(start);
        return this;
    }

    public Meeting duration(java.time.Duration duration) {
        this.duration = new Duration(duration);
        return this;
    }

    public Meeting required(Participant participant) {
        required.add(participant);
        return this;
    }

    public Meeting optional(Participant participant) {
        optional.add(participant);
        return this;
    }

    public Meeting chair(Participant participant) {
        this.chair = participant;
        return this;
    }

    public Meeting location(VLocation location) {
        this.location = location;
        return this;
    }

    public Meeting agenda(VToDo agenda) {
        this.agenda = agenda;
        return this;
    }

    @Override
    public VEvent apply(VEvent vEvent) {
        // apply mandatory properties..
        vEvent.replace(EventType.MEETING);
        replaceIfNotNull(vEvent, organizer);
        replaceIfNotNull(vEvent, uid);
        replaceIfNotNull(vEvent, summary);
        replaceIfNotNull(vEvent, start);
        replaceIfNotNull(vEvent, duration);

        if (chair != null) {
            vEvent.add(chair);
            vEvent.add(new Attendee(CHAIR_PARAMS, chair));
        }
        required.forEach(p -> {
            vEvent.add(p);
            vEvent.add(new Attendee(REQUIRED_PARAMS, p));
        });
        optional.forEach(p -> {
            vEvent.add(p);
            vEvent.add(new Attendee(OPTIONAL_PARAMS, p));
        });
//        if (location != null) {
//            vEvent.add(location);
//        }
//        resources.forEach(vEvent::add);
//        if (agenda != null) {
//            vEvent.add(new Link(agenda));
//        }
        //todo: for each existing attendee add corresponding participant component..
        return vEvent;
    }
}
