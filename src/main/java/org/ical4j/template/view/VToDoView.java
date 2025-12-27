package org.ical4j.template.view;

import net.fortuna.ical4j.model.Period;
import net.fortuna.ical4j.model.component.VToDo;

import java.time.ZoneId;
import java.time.temporal.Temporal;

public class VToDoView extends AbstractComponentView implements DescriptivePropertyView<VToDo>,
    DateTimePropertyView<VToDo>, RecurrenceView<VToDo, VToDo> {

    private final VToDo todo;

    private final Temporal periodStart;

    private final Temporal periodEnd;

    private final ZoneId zoneId;

    public VToDoView(VToDo todo) {
        this(todo, null, null, ZoneId.systemDefault());
    }

    public VToDoView(VToDo todo, ZoneId zoneId) {
        this(todo, null, null, zoneId);
    }

    public VToDoView(VToDo todo, Temporal periodStart, Temporal periodEnd) {
        this(todo, periodStart, periodEnd, ZoneId.systemDefault());
    }

    public VToDoView(VToDo todo, Temporal periodStart, Temporal periodEnd, ZoneId zoneId) {
        this.todo = todo;
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
        this.zoneId = zoneId;
    }

    @Override
    public VToDo getPropertyAccessor() {
        return todo;
    }

    @Override
    public ZoneId getZoneId() {
        return zoneId;
    }

    @Override
    public VToDo getRecurrenceSupport() {
        return todo;
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
        return "Summary: " + getSummary() + "\n" +
               "Start: " + getStart() + "\n" +
               "Due: " + getDue() + "\n" +
               "Status: " + getStatus() + "\n" +
               "Priority: " + getPriority() + "\n" +
               "Percent Complete: " + getPercentComplete();
    }

    public static class VToDoViewFactory implements ViewFactory<VToDo, VToDoView> {

        public static final VToDoViewFactory INSTANCE = new VToDoViewFactory();

        @Override
        public VToDoView createView(VToDo model) {
            return new VToDoView(model);
        }
    }
}
