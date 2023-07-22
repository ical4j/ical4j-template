package org.ical4j.template.vevent;

import net.fortuna.ical4j.model.DateList;
import net.fortuna.ical4j.model.PropertyList;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.*;
import net.fortuna.ical4j.model.property.immutable.ImmutableTransp;
import net.fortuna.ical4j.util.RandomUidGenerator;
import org.ical4j.template.AbstractCalendarTemplate;
import org.ical4j.template.property.Repeats;

import java.net.URI;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Creates an (optionally recurring) date-based {@link VEvent} representing a public holiday or
 * other observance.
 *
 * Includes observances from <a href="https://www.un.org/en/observances/list-days-weeks"> UN International Days</a>.
 */
public class Observance extends AbstractCalendarTemplate<VEvent> {

    public Observance(String summary, LocalDate... dates) {
        this(summary, null, dates);
    }

    public Observance(String summary, String url, LocalDate... dates) {
        super(new VEvent(new PropertyList(Arrays.asList(new RandomUidGenerator().generateUid(),
                new DtStamp(), ImmutableTransp.TRANSPARENT, new Summary(summary)))));
        if (url != null) {
            getRevisions().getLatestRevision().add(new Url(URI.create(url)));
        }
        if (dates.length > 0) {
            List<LocalDate> dateList = Arrays.asList(dates);
            Collections.sort(dateList);
            getRevisions().getLatestRevision().add(new DtStart<>(dateList.get(0)));
            getRevisions().getLatestRevision().add(new RDate<>(new DateList<>(dateList.subList(1, dateList.size()))));
        }
    }

    @Override
    public <T extends AbstractCalendarTemplate<VEvent>> T getFluentTarget() {
        return (T) this;
    }

    public Observance title(String title) {
        getRevisions().getLatestRevision().add(new Summary(title));
        return this;
    }

    public Observance date(LocalDate date) {
        getRevisions().getLatestRevision().add(new DtStart<>(date));
        return this;
    }

    public Observance repeats(Repeats<LocalDate> repeats) {
        getRevisions().getLatestRevision().add(repeats);
        return this;
    }
}
