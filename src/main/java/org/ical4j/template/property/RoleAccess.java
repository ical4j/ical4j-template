package org.ical4j.template.property;

import net.fortuna.ical4j.model.property.Clazz;
import net.fortuna.ical4j.model.property.ImmutableProperty;

public class RoleAccess extends Clazz implements ImmutableProperty {

    public static final RoleAccess ADMIN = new RoleAccess("ADMIN");
    
    public RoleAccess(String access) {
        super(access);
    }
}
