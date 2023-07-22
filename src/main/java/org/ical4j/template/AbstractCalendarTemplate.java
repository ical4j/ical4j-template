package org.ical4j.template;

import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.ComponentGroup;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.component.CalendarComponent;
import net.fortuna.ical4j.model.property.RecurrenceId;
import net.fortuna.ical4j.model.property.Uid;

import java.util.Collections;
import java.util.Optional;

/**
 * Implementors provide a template for common iCalendar and vCard use-cases.
 */
public abstract class AbstractCalendarTemplate<T extends CalendarComponent> implements FluentCalendarTemplate<T> {

    private final ComponentGroup<T> revisions;

    public AbstractCalendarTemplate(T initialValue) {
        Uid uid = initialValue.getRequiredProperty(Property.UID);
        Optional<RecurrenceId<?>> recurrenceId = initialValue.getProperty(Property.RECURRENCE_ID);
        this.revisions = recurrenceId.map(id -> new ComponentGroup<>(Collections.singletonList(initialValue), uid, id))
                .orElseGet(() -> new ComponentGroup<>(Collections.singletonList(initialValue), uid));
    }

    public ComponentGroup<T> getRevisions() {
        return revisions;
    }

    /**
     * Produce a {@link Calendar} representation of the object.
     * @return a calendar instance
     */
    public Calendar toCalendar() {
        return new Calendar(getRevisions().getComponentList()).withDefaults().getFluentTarget();
    }

    @Override
    public String toString() {
        return toCalendar().toString();
    }
}
