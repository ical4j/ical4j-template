package org.ical4j.template.vevent;

import net.fortuna.ical4j.model.DateList;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.DtStart;
import net.fortuna.ical4j.model.property.RDate;
import net.fortuna.ical4j.model.property.Summary;
import org.ical4j.template.property.Repeats;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static net.fortuna.ical4j.model.property.immutable.ImmutableTransp.TRANSPARENT;

/**
 * Creates an (optionally recurring) date-based {@link VEvent} representing a public holiday or
 * other observance.
 */
public class Observance extends VEvent {

    public static final Observance CHRISTMAS_DAY = new Observance("Christmas Day",
            LocalDate.of(0, Month.DECEMBER, 25)).repeats(Repeats.YEARLY);

    public static final Observance NEW_YEARS_DAY = new Observance("New Years Day",
            LocalDate.of(0, Month.JANUARY, 1)).repeats(Repeats.YEARLY);

    public Observance(String summary, LocalDate... dates) {
        add(TRANSPARENT);
        add(new Summary(summary));
        if (dates.length > 0) {
            List<LocalDate> dateList = Arrays.asList(dates);
            Collections.sort(dateList);
            add(new DtStart<>(dateList.get(0)));
            add(new RDate<>(new DateList<>(dateList.subList(1, dateList.size()))));
        }
    }

    public Observance title(String title) {
        add(new Summary(title));
        return this;
    }

    public Observance date(LocalDate date) {
        if (getProperty(Property.DTSTART).isPresent()) {
            add(new RDate<>(new DateList<>(date)));
        } else {
            add(new DtStart<>(date));
        }
        return this;
    }

    public Observance repeats(Repeats<LocalDate> repeats) {
        add(repeats);
        return this;
    }
}
