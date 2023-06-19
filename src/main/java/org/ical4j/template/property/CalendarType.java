package org.ical4j.template.property;

import net.fortuna.ical4j.model.Parameter;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.TextList;
import net.fortuna.ical4j.model.property.Categories;
import net.fortuna.ical4j.model.property.ImmutableProperty;

/**
 * Use the {@link Categories} property to define common types of components.
 */
public class CalendarType extends Categories implements ImmutableProperty {

    public static final CalendarType PROJECT = new CalendarType("PROJECT");

    public static final CalendarType TIMESHEET = new CalendarType("TIMESHEET");

    public static final CalendarType ROSTER = new CalendarType("ROSTER");

    public CalendarType(String type) {
        super(new TextList(type));
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
