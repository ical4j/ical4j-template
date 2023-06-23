package org.ical4j.template.valarm;

import net.fortuna.ical4j.model.component.VAlarm;
import net.fortuna.ical4j.model.property.immutable.ImmutableAction;
import org.ical4j.template.property.Notify;

public class EmailNotification extends VAlarm {

    public EmailNotification(Notify notify) {
        add(ImmutableAction.EMAIL);
        add(notify);
    }
}
