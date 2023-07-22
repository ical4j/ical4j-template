package org.ical4j.template.valarm;

import net.fortuna.ical4j.model.component.VAlarm;
import net.fortuna.ical4j.model.property.immutable.ImmutableAction;
import org.ical4j.template.property.Notify;

public class DisplayNotification extends VAlarm {

    public DisplayNotification(Notify notify) {
        add(ImmutableAction.DISPLAY);
        add(notify);
    }
}
