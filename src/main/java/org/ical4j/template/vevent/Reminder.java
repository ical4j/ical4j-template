package org.ical4j.template.vevent;

import net.fortuna.ical4j.model.PropertyList;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.DtStamp;
import net.fortuna.ical4j.model.property.DtStart;
import net.fortuna.ical4j.model.property.Duration;
import net.fortuna.ical4j.model.property.Summary;
import net.fortuna.ical4j.model.property.immutable.ImmutableTransp;
import net.fortuna.ical4j.util.RandomUidGenerator;
import org.ical4j.template.AbstractCalendarTemplate;
import org.ical4j.template.property.EventType;
import org.ical4j.template.property.Notify;
import org.ical4j.template.property.Repeats;

import java.time.temporal.Temporal;
import java.util.Arrays;

/**
 * A transparent event used as a reminder of a particular date/time. This component MAY include
 * an alarm.
 */
public class Reminder extends AbstractCalendarTemplate<VEvent> {

    public Reminder(String summary, Temporal temporal) {
        super(new VEvent(new PropertyList(Arrays.asList(new RandomUidGenerator().generateUid(),
                new DtStamp(), EventType.REMINDER, ImmutableTransp.TRANSPARENT, new Summary(summary),
                new DtStart<>(temporal), new Duration(java.time.Duration.ZERO)))));
    }

    @Override
    public <T extends AbstractCalendarTemplate<VEvent>> T getFluentTarget() {
        return (T) this;
    }

    public Reminder notify(Notify notify) {
        getRevisions().getLatestRevision().add(notify);
        return this;
    }

    public Reminder repeats(Repeats<?> repeats) {
        getRevisions().getLatestRevision().add(repeats);
        return this;
    }
}
