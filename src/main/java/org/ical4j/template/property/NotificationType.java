package org.ical4j.template.property;

import net.fortuna.ical4j.model.property.Action;
import net.fortuna.ical4j.model.property.ImmutableProperty;

public class NotificationType extends Action implements ImmutableProperty {

    public static final NotificationType SMS = new NotificationType("X-SMS");

    public static final NotificationType TOPIC  = new NotificationType("X-TOPIC");

    public static final NotificationType QUEUE  = new NotificationType("X-QUEUE");

    public NotificationType(String action) {
        super(action);
    }
}
