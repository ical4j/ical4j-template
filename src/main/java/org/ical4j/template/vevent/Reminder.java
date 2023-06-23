package org.ical4j.template.vevent;

import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.DtStart;
import net.fortuna.ical4j.model.property.Duration;
import net.fortuna.ical4j.model.property.immutable.ImmutableTransp;
import org.ical4j.template.property.ComponentType;
import org.ical4j.template.property.Notify;
import org.ical4j.template.property.Repeats;

import java.time.LocalDate;
import java.time.temporal.Temporal;

/**
 * A transparent event used as a reminder of a particular date/time. This component MUST include
 * an alarm.
 */
public class Reminder extends VEvent {

    public Reminder(String summary, Temporal temporal) {
        add(ComponentType.REMINDER);
        add(ImmutableTransp.TRANSPARENT);
        add(new DtStart<>(temporal));
        add(new Duration(java.time.Duration.ZERO));
    }

    public Reminder notify(Notify notify) {
        add(notify);
        return this;
    }

    public Reminder repeats(Repeats<?> repeats) {
        add(repeats);
        return this;
    }
}
