package org.ical4j.template.view;

import net.fortuna.ical4j.model.Parameter;
import net.fortuna.ical4j.model.Period;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.DtEnd;
import net.fortuna.ical4j.model.property.DtStart;
import net.fortuna.ical4j.vcard.parameter.Value;
import org.ical4j.template.util.EmojiProvider;

import java.time.ZoneId;
import java.time.temporal.Temporal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class VEventView extends AbstractComponentView {

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

    public String getSummary() {
        return Objects.requireNonNull(event.getSummary()).getValue();
    }

    public String getStart() {
        DtStart<?> dtStart = event.getDateTimeStart();
        if (Optional.of(Value.DATE).equals(dtStart.getParameter(Parameter.VALUE))) {
            return getLocalizedDateString(Objects.requireNonNull(dtStart).getDate());
        } else {
            return getLocalizedDateTimeString(Objects.requireNonNull(dtStart).getDate(), zoneId);
        }
    }

    public String getEnd() {
        DtEnd<?> dtEnd = event.getDateTimeEnd();
        if (Optional.of(Value.DATE).equals(dtEnd.getParameter(Parameter.VALUE))) {
            return getLocalizedDateString(Objects.requireNonNull(dtEnd).getDate());
        } else {
            return getLocalizedDateTimeString(Objects.requireNonNull(dtEnd).getDate(), zoneId);
        }
    }

    public String getLocation() {
        return event.getLocation() != null ? EmojiProvider.getEmoji("location") + " "
                + event.getLocation().getValue() : "";
    }

    public String getStatus() {
        return getStatusString(event.getStatus());
    }

    public String getPriority() {
        return getPriorityString(event.getPriority());
    }

    public List<String> getOccurrences() {
        if (periodStart != null && periodEnd != null) {
            List<VEvent> occurrences = event.getOccurrences(new Period<>(periodStart, periodEnd));
            return occurrences.stream().map(o -> new VEventView(o).getStart()).collect(Collectors.toList());
        }
        return List.of(getStart());
    }

    @Override
    public String toString() {
        String value = "Summary: " + getSummary() + "\n" +
                "Start: " + getStart() + "\n" +
                "End: " + getEnd() + "\n";

        if (!getLocation().isBlank()) {
            value += "Location: " + getLocation() + "\n";
        }
        return value;
    }
}
