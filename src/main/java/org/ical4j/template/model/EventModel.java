package org.ical4j.template.model;

import net.fortuna.ical4j.model.component.VEvent;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Objects;

public class EventModel {

    private final VEvent event;

    public EventModel(VEvent event) {
        this.event = event;
    }

    public String getSummary() {
        return Objects.requireNonNull(event.getSummary()).getValue();
    }

    public String getStart() {
        return DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format(
                Objects.requireNonNull(event.getDateTimeStart()).getDate());
    }

    public  String getEnd() {
        return DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format(
                Objects.requireNonNull(event.getDateTimeEnd()).getDate());
    }

    @Override
    public String toString() {
        return "Summary: " + getSummary() + "\n" +
                "Start: " + getStart() + "\n" +
                "End: " + getEnd() + "\n";
    }
}
