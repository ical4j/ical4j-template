package org.ical4j.template.vevent;

import net.fortuna.ical4j.model.PropertyList;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.*;
import net.fortuna.ical4j.model.property.immutable.ImmutableTransp;
import net.fortuna.ical4j.util.RandomUidGenerator;
import org.ical4j.template.AbstractCalendarTemplate;
import org.ical4j.template.property.Repeats;

import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;
import java.util.Arrays;

/**
 * Defines one or more time-boxed periods for work completion.
 */
public class Timebox extends AbstractCalendarTemplate<VEvent> {

    public Timebox(String summary, Temporal start, Temporal end) {
        super(new VEvent(new PropertyList(Arrays.asList(new RandomUidGenerator().generateUid(),
                new DtStamp(), ImmutableTransp.TRANSPARENT, new Summary(summary),
                new DtStart<>(start), new DtEnd<>(end)))));
    }

    public Timebox(String summary, Temporal start, TemporalAmount duration) {
        super(new VEvent(new PropertyList(Arrays.asList(new RandomUidGenerator().generateUid(),
                new DtStamp(), ImmutableTransp.TRANSPARENT, new Summary(summary),
                new DtStart<>(start), new Duration(duration)))));
    }

    @Override
    public <T extends AbstractCalendarTemplate<VEvent>> T getFluentTarget() {
        return (T) this;
    }

    Timebox repeats(Repeats<?> repeats) {
        getRevisions().getLatestRevision().replace(repeats);
        return this;
    }
}
