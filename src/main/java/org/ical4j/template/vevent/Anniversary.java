package org.ical4j.template.vevent;

import net.fortuna.ical4j.model.PropertyList;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.DtStamp;
import net.fortuna.ical4j.model.property.DtStart;
import net.fortuna.ical4j.model.property.Summary;
import net.fortuna.ical4j.model.property.immutable.ImmutableTransp;
import net.fortuna.ical4j.util.RandomUidGenerator;
import org.ical4j.template.AbstractCalendarTemplate;
import org.ical4j.template.property.Repeats;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * Creates a recurring {@link VEvent} representing a birthday/anniversary, etc.
 */
public class Anniversary extends AbstractCalendarTemplate<VEvent> {

    public Anniversary(LocalDate date) {
        super(new VEvent(new PropertyList(Arrays.asList(new RandomUidGenerator().generateUid(),
                new DtStamp(), ImmutableTransp.TRANSPARENT, Repeats.YEARLY,
                new DtStart<>(date)))));
    }

    public Anniversary(String summary, LocalDate date) {
        super(new VEvent(new PropertyList(Arrays.asList(new RandomUidGenerator().generateUid(),
                new DtStamp(), ImmutableTransp.TRANSPARENT, Repeats.YEARLY,
                new DtStart<>(date), new Summary(summary)))));
    }

    @Override
    public <T extends AbstractCalendarTemplate<VEvent>> T getFluentTarget() {
        return (T) this;
    }

    public Anniversary withSummary(String summary) {
        getRevisions().getLatestRevision().replace(new Summary(summary));
        return this;
    }
}
