package org.ical4j.template.vresource;

import net.fortuna.ical4j.model.component.VResource;
import net.fortuna.ical4j.model.property.Name;
import net.fortuna.ical4j.model.property.immutable.ImmutableResourceType;

public class Room extends VResource {

    public Room(String name) {
        add(ImmutableResourceType.ROOM);
        add(new Name(name));
    }
}
