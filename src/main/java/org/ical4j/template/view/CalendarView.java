package org.ical4j.template.view;

import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Period;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.component.VEvent;

import java.time.temporal.Temporal;
import java.util.Collection;
import java.util.List;

public class CalendarView {

    private final Calendar calendar;

    public CalendarView(Calendar calendar) {
        this.calendar = calendar;
    }

    public String getName() {
        List<Property> names = calendar.getProperties(Property.NAME, "X-WR-CALNAME");
        if (!names.isEmpty()) {
            return names.get(0).getValue();
        } else {
            return "";
        }
    }

    public List<VEventView> getEvents(Period<Temporal> period) {
        List<VEvent> events = calendar.getComponents("VEVENT");
        if (period != null) {
            return events.stream().map(e -> e.getOccurrences(period)).flatMap(Collection::stream)
                    .filter(e -> period.includes(e.getDateTimeStart().getDate()))
                    .map(e -> new VEventView(e, null)).toList();
        } else {
            return events.stream().map(e -> new VEventView(e, null)).toList();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!getName().isBlank()) {
            sb.append("Calendar Name: ").append(getName()).append("\n");
        }
        sb.append("Events:\n");
        for (VEventView event : getEvents(null)) {
            sb.append(event.toString()).append("\n");
        }
        return sb.toString();
    }
}
