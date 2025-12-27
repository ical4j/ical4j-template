package org.ical4j.template.view;

import net.fortuna.ical4j.model.Period;
import net.fortuna.ical4j.model.component.VEvent;

import java.time.ZoneId;
import java.time.temporal.Temporal;

public class VEventView extends AbstractComponentView implements DescriptivePropertyView<VEvent>,
    DateTimePropertyView<VEvent>, RecurrenceView<VEvent, VEvent> {

    private final VEvent event;

    private final Temporal periodStart;

    private final Temporal periodEnd;

    private final ZoneId zoneId;

    public VEventView(VEvent event) {
        this(event, null, null, ZoneId.systemDefault());
    }

    public VEventView(VEvent event, ZoneId zoneId) {
        this(event, null, null, zoneId);
    }

    public VEventView(VEvent event, Temporal periodStart, Temporal periodEnd) {
        this(event, periodStart, periodEnd, ZoneId.systemDefault());
    }

    public VEventView(VEvent event, Temporal periodStart, Temporal periodEnd, ZoneId zoneId) {
        this.event = event;
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
        this.zoneId = zoneId;
    }

    @Override
    public VEvent getPropertyAccessor() {
        return event;
    }

    @Override
    public ZoneId getZoneId() {
        return zoneId;
    }

    @Override
    public VEvent getRecurrenceSupport() {
        return event;
    }

    @Override
    public Period<Temporal> getPeriod() {
        if (periodStart != null && periodEnd != null) {
            return new Period<>(periodStart, periodEnd);
        }
        return null;
    }

    @Override
    public String toString() {
        String value = "Summary: " + getSummary() + "\n" +
                "Start: " + getStart() + "\n" +
                "End: " + getEnd() + "\n";

        if (!getLocation().isBlank()) {
            value += "Location: " + getLocation() + "\n";
        }

        if (getPeriod() != null) {
            value += "Occurrences: " + String.join(", ", getOccurrences(VEventViewFactory.INSTANCE)) + "\n";
        }
        return value;
    }

    public static class VEventViewFactory implements ViewFactory<VEvent> {

        public static final VEventViewFactory INSTANCE = new VEventViewFactory();

        @Override
        public Object createView(VEvent model) {
            return new VEventView(model);
        }
    }
}
