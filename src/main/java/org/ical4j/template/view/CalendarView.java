package org.ical4j.template.view;

import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.component.CalendarComponent;

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

    public List<String> getEvents() {
        List<CalendarComponent> events = calendar.getComponents("VEVENT");
        return events.stream().map(e ->
                new EventView((net.fortuna.ical4j.model.component.VEvent) e, null).toString()).toList();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!getName().isBlank()) {
            sb.append("Calendar Name: ").append(getName()).append("\n");
        }
        sb.append("Events:\n");
        for (String eventStr : getEvents()) {
            sb.append(eventStr).append("\n");
        }
        return sb.toString();
    }
}
