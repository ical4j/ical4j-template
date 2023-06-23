package org.ical4j.template.vevent;

import net.fortuna.ical4j.model.*;
import net.fortuna.ical4j.model.component.*;
import net.fortuna.ical4j.model.parameter.Role;
import net.fortuna.ical4j.model.property.*;
import org.ical4j.template.TemplateProvider;
import org.ical4j.template.property.*;

import java.time.ZonedDateTime;
import java.util.List;

import static java.util.Collections.singletonList;
import static net.fortuna.ical4j.model.property.immutable.ImmutableTransp.OPAQUE;

/**
 * Creates a {@link VEvent} representing a meeting of one or more attendees.
 */
public class Meeting extends VEvent {

    public Meeting(String summary, ZonedDateTime start) {
        add(ComponentType.MEETING);
        add(new Summary(summary));
        add(new DtStart<>(start));
    }

    public Meeting required(Participant participant) {
        add(participant);
        add(new Required(participant));
        return this;
    }

    public Meeting optional(Participant participant) {
        add(participant);
        add(new Optional(participant));
        return this;
    }

    public Meeting chair(Participant participant) {
        add(participant);
        add(new Chair(participant));
        return this;
    }

    public Meeting attendee(Participant participant, Role role) {
        add(participant);
        add(new Attendee(new ParameterList(singletonList(role)), participant));
        return this;
    }

    public Meeting location(VLocation location) {
        add(location);
        add(new Location(location));
        return this;
    }

    public Meeting resource(VResource resource) {
        add(resource);
        //XXX: problematic as only allowed one resources property according to RFC5545..
        add(new Resources(resource));
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
        add(agenda);
        if (deriveDescription) {
//            add(agenda.newDescriptionFactory().createProperty());
//            add(agenda.newStyledDescriptionFactory().createProperty());
        }
        return this;
    }

    public static class Factory extends Appointment.Factory {
        @Override
        public VEvent createComponent() {
            List<Property> props = singletonList(OPAQUE);
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

    public static class Provider implements TemplateProvider<VEvent> {

        @Override
        public String getName() {
            return "meeting";
        }

        @Override
        public String getDescription() {
            return "Create a new meeting event";
        }

        @Override
        public ComponentFactory<VEvent> get() {
            return new Factory();
        }
    }
}
