package org.ical4j.template.property;

import net.fortuna.ical4j.model.property.Clazz;
import net.fortuna.ical4j.model.property.ImmutableProperty;

public class Visibility extends Clazz implements ImmutableProperty {

    public static final Visibility ADMIN = new Visibility("ADMIN");
    
    public Visibility(String access) {
        super(access);
    }
}
