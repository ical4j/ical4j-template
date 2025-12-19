package org.ical4j.template.model;

import net.fortuna.ical4j.model.Period;
import net.fortuna.ical4j.model.component.VEvent;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.Temporal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class EventModel {

    private final VEvent event;

    private final Temporal periodStart;

    private final Temporal periodEnd;

    public EventModel(VEvent event) {
        this(event, null, null);
    }

    public EventModel(VEvent event, Temporal periodStart, Temporal periodEnd) {
        this.event = event;
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
    }

    public String getSummary() {
        return Objects.requireNonNull(event.getSummary()).getValue();
    }

    public String getStart() {
        return DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format(
                Objects.requireNonNull(event.getDateTimeStart()).getDate());
    }

    public String getEnd() {
        return DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format(
                Objects.requireNonNull(event.getDateTimeEnd()).getDate());
    }

    public List<String> getOccurrences() {
        if (periodStart != null && periodEnd != null) {
            List<VEvent> occurrences = event.getOccurrences(new Period<>(periodStart, periodEnd));
            return occurrences.stream().map(o -> new EventModel(o).getStart()).collect(Collectors.toList());
        }
        return List.of(getStart());
    }

    @Override
    public String toString() {
        return "Summary: " + getSummary() + "\n" +
                "Start: " + getStart() + "\n" +
                "End: " + getEnd() + "\n";
    }
}
