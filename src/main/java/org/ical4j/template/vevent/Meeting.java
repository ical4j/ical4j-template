package org.ical4j.template.vevent;

import net.fortuna.ical4j.model.ParameterList;
import net.fortuna.ical4j.model.PropertyList;
import net.fortuna.ical4j.model.component.Participant;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.component.VLocation;
import net.fortuna.ical4j.model.component.VResource;
import net.fortuna.ical4j.model.parameter.Role;
import net.fortuna.ical4j.model.property.*;
import net.fortuna.ical4j.util.RandomUidGenerator;
import org.ical4j.template.AbstractCalendarTemplate;
import org.ical4j.template.property.*;

import java.time.ZonedDateTime;
import java.util.Arrays;

import static java.util.Collections.singletonList;

/**
 * Creates a {@link VEvent} representing a meeting of one or more attendees.
 */
public class Meeting extends AbstractCalendarTemplate<VEvent> {

    public Meeting(String summary, ZonedDateTime start) {
        super(new VEvent(new PropertyList(Arrays.asList(new RandomUidGenerator().generateUid(),
                new DtStamp(), EventType.MEETING, new Summary(summary),
                new DtStart<>(start)))));
    }

    @Override
    public <T extends AbstractCalendarTemplate<VEvent>> T getFluentTarget() {
        return (T) this;
    }

    public Meeting required(Participant participant) {
        getRevisions().getLatestRevision().add(participant);
        getRevisions().getLatestRevision().add(new Required(participant));
        return this;
    }

    public Meeting optional(Participant participant) {
        getRevisions().getLatestRevision().add(participant);
        getRevisions().getLatestRevision().add(new Optional(participant));
        return this;
    }

    public Meeting chair(Participant participant) {
        getRevisions().getLatestRevision().add(participant);
        getRevisions().getLatestRevision().add(new Chair(participant));
        return this;
    }

    public Meeting attendee(Participant participant, Role role) {
        getRevisions().getLatestRevision().add(participant);
        getRevisions().getLatestRevision().add(new Attendee(new ParameterList(singletonList(role)), participant));
        return this;
    }

    public Meeting location(VLocation location) {
        getRevisions().getLatestRevision().add(location);
        getRevisions().getLatestRevision().add(new Location(location));
        return this;
    }

    public Meeting resource(VResource resource) {
        getRevisions().getLatestRevision().add(resource);
        //XXX: problematic as only allowed one resources property according to RFC5545..
        getRevisions().getLatestRevision().add(new Resources(resource));
        return this;
    }

    public Meeting withAgenda(Html agenda) {
        return withAgenda(agenda, true);
    }

    /**
     * Attach an agenda to the meeting, and if required derive the DESCRIPTION and
     * STYLED-DESCRIPTION properties from the agenda content.
     * @param agenda
     * @param deriveDescription
     * @return
     */
    public Meeting withAgenda(Html agenda, boolean deriveDescription) {
        getRevisions().getLatestRevision().add(agenda);
        if (deriveDescription) {
//            add(agenda.newDescriptionFactory().createProperty());
//            add(agenda.newStyledDescriptionFactory().createProperty());
        }
        return this;
    }
}
