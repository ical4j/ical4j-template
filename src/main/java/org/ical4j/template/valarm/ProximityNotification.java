package org.ical4j.template.valarm;

import net.fortuna.ical4j.model.component.VAlarm;
import net.fortuna.ical4j.model.component.VLocation;
import net.fortuna.ical4j.model.property.Proximity;

public class ProximityNotification extends VAlarm {

    public ProximityNotification(Proximity proximity, VLocation location) {
        add(proximity);
        add(location);
    }
}
