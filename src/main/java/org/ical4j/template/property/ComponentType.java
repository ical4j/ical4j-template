package org.ical4j.template.property;

import net.fortuna.ical4j.model.Parameter;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.TextList;
import net.fortuna.ical4j.model.property.Categories;
import net.fortuna.ical4j.model.property.ImmutableProperty;

/**
 * Use the {@link Categories} property to define common types of components.
 */
public class ComponentType extends Categories implements ImmutableProperty {

    public static final ComponentType MEETING = new ComponentType("MEETING");

    public static final ComponentType APPOINTMENT = new ComponentType("APPOINTMENT");

    public static final ComponentType TASK = new ComponentType("TASK");

    public static final ComponentType REMINDER = new ComponentType("REMINDER");

    public ComponentType(String type) {
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
