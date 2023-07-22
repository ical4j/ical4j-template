package org.ical4j.template.property;

import net.fortuna.ical4j.model.Parameter;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.property.Categories;
import net.fortuna.ical4j.model.property.Concept;
import net.fortuna.ical4j.model.property.ImmutableProperty;

import java.net.URI;

/**
 * Use the {@link Categories} property to define common types of components.
 */
public class EventType extends Concept implements ImmutableProperty {

    public static final EventType MEETING = new EventType("https://ical4j.org/event-types/MEETING");

    public static final EventType APPOINTMENT = new EventType("https://ical4j.org/event-types/APPOINTMENT");

    public static final EventType REMINDER = new EventType("https://ical4j.org/event-types/REMINDER");
    public static final EventType PERFORMANCE = new EventType("https://ical4j.org/event-types/PERFORMANCE");

    public EventType(String type) {
        super(URI.create(type));
    }

    @Override
    public <T extends Property> T add(Parameter parameter) {
        return ImmutableProperty.super.add(parameter);
    }

    @Override
    public <T extends Property> T remove(Parameter parameter) {
        return ImmutableProperty.super.remove(parameter);
    }

    @Override
    public <T extends Property> T removeAll(String... parameterName) {
        return ImmutableProperty.super.removeAll(parameterName);
    }

    @Override
    public <T extends Property> T replace(Parameter parameter) {
        return ImmutableProperty.super.replace(parameter);
    }

    @Override
    public void setValue(final String aValue) {
        ImmutableProperty.super.setValue(aValue);
    }
}
