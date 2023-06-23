package org.ical4j.template.valarm;

import net.fortuna.ical4j.model.component.VAlarm;
import org.ical4j.template.property.NotificationType;

public class SMSNotification extends VAlarm {

    public SMSNotification() {
        add(NotificationType.SMS);
    }
}
