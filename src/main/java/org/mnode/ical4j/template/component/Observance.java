package org.mnode.ical4j.template.component;

import net.fortuna.ical4j.model.Recur;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.RRule;

import java.time.LocalDate;

import static net.fortuna.ical4j.model.property.Transp.TRANSPARENT;

/**
 * Creates an (optionally recurring) date-based {@link VEvent} representing a public holiday or
 * other observance.
 */
public class Observance extends VEvent {

    private String title;

    private LocalDate date;

    private Recur<LocalDate> recurrence;

    public Observance title(String title) {
        this.title = title;
        return this;
    }

    public Observance date(LocalDate date) {
        this.date = date;
        return this;
    }

    public Observance recurrence(Recur<LocalDate> recurrence) {
        this.recurrence = recurrence;
        return this;
    }

    public VEvent build() {
        VEvent observance = new VEvent(date, title);
        observance.add(new RRule<>(recurrence));
        observance.add(TRANSPARENT);

        return observance;
    }
}
