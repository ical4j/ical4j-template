package org.ical4j.template.vevent;

import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.DtEnd;
import net.fortuna.ical4j.model.property.DtStart;
import net.fortuna.ical4j.model.property.Duration;
import net.fortuna.ical4j.model.property.Summary;
import net.fortuna.ical4j.model.property.immutable.ImmutableTransp;
import org.ical4j.template.property.Repeats;

import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;

/**
 * Defines one or more time-boxed periods for work completion.
 */
public class Timebox extends VEvent {

    public Timebox(String summary, Temporal start, Temporal end) {
        add(ImmutableTransp.TRANSPARENT);
        add(new Summary(summary));
        add(new DtStart<>(start));
        add(new DtEnd<>(end));
    }

    public Timebox(String summary, Temporal start, TemporalAmount duration) {
        add(ImmutableTransp.TRANSPARENT);
        add(new Summary(summary));
        add(new DtStart<>(start));
        add(new Duration(duration));
    }

    Timebox repeats(Repeats<?> repeats) {
        replace(repeats);
        return this;
    }
}
