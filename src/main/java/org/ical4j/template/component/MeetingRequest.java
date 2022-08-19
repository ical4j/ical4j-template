package org.ical4j.template.component;

import net.fortuna.ical4j.model.ComponentList;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.PropertyList;
import net.fortuna.ical4j.model.Recur;
import net.fortuna.ical4j.model.component.VAlarm;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.Attendee;
import net.fortuna.ical4j.model.property.Organizer;
import net.fortuna.ical4j.model.property.immutable.ImmutableMethod;
import org.ical4j.template.property.MeetingAgenda;

import java.net.URISyntaxException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static net.fortuna.ical4j.model.property.immutable.ImmutableTransp.OPAQUE;

/**
 * Creates a {@link VEvent} representing a meeting of one or more attendees.
 */
public class MeetingRequest extends Appointment {

    private String title;

    private ZonedDateTime dateTime;

    private Organizer organizer;

    private List<Attendee> attendees = new ArrayList<>();

    private Recur recurrence;

    public MeetingRequest() {
        add(ImmutableMethod.REQUEST);
    }

    public MeetingRequest withAttendee(String attendee) throws URISyntaxException {
        add(new Attendee(attendee));
        return this;
    }

    public MeetingRequest withAgenda(MeetingAgenda agenda) {
        return withAgenda(agenda, true);
    }

    /**
     * Attach an agenda to the meeting, and if required derive the DESCRIPTION and
     * STYLED-DESCRIPTION properties from the agenda content.
     * @param agenda
     * @param deriveDescription
     * @return
     */
    public MeetingRequest withAgenda(MeetingAgenda agenda, boolean deriveDescription) {
        add(agenda);
        if (deriveDescription) {
            add(agenda.newDescriptionFactory().createProperty());
            add(agenda.newStyledDescriptionFactory().createProperty());
        }
        return this;
    }

    public static class Factory extends Appointment.Factory {
        @Override
        public VEvent createComponent() {
            List<Property> props = Collections.singletonList(OPAQUE);
            return super.createComponent(new PropertyList(props));
        }

        @Override
        public VEvent createComponent(PropertyList properties) {
            PropertyList props = (PropertyList) properties.add(OPAQUE);
            return super.createComponent(props);
        }

        @Override
        public VEvent createComponent(PropertyList properties, ComponentList<?> subComponents) {
            PropertyList props = (PropertyList) properties.add(OPAQUE);
            return new VEvent(properties, (ComponentList<VAlarm>) subComponents);
        }
    }
}
