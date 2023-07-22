package org.ical4j.template.property;

import net.fortuna.ical4j.model.property.Clazz;
import net.fortuna.ical4j.model.property.ImmutableProperty;

public class Sensitivity extends Clazz implements ImmutableProperty {

    public static final Sensitivity GENERAL = new Sensitivity("GENERAL");

    public static final Sensitivity CONFIDENTIAL = new Sensitivity("CONFIDENTIAL");
    
    public static final Sensitivity RESTRICTED = new Sensitivity("RESTRICTED");

    public Sensitivity(String access) {
        super(access);
    }
}
