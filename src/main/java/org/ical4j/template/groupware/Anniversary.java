package org.ical4j.template.groupware;

import net.fortuna.ical4j.extensions.property.Repeats;
import net.fortuna.ical4j.model.component.VEvent;
import org.ical4j.template.AbstractTemplate;

import java.time.LocalDate;

import static net.fortuna.ical4j.model.DateTimePropertyModifiers.DTSTART;
import static net.fortuna.ical4j.model.RecurrencePropertyModifiers.RRULE;

/**
 * Creates a recurring {@link VEvent} representing a birthday/anniversary, etc.
 */
public class Anniversary extends AbstractTemplate<VEvent> {

    private Repeats<?> schedule;

    private LocalDate date;

    public Anniversary() {
        super(VEvent.class);
    }

    public Anniversary(Class<? extends VEvent> typeClass) {
        super(typeClass);
    }

    public <T extends VEvent> Anniversary(T prototype) {
        super(prototype.getClass());
        setPrototype(prototype);
    }

    public Anniversary withRepeats(Repeats<?> schedule) {
        this.schedule = schedule;
        return this;
    }

    public Anniversary withDate(LocalDate date) {
        this.date = date;
        return this;
    }

    @Override
    public VEvent apply(VEvent vEvent) {
        applyPrototype(vEvent);

        vEvent.with(DTSTART, date);
        vEvent.with(RRULE, schedule);
        return vEvent;
    }
}
