package org.ical4j.template.view;

import net.fortuna.ical4j.model.component.VToDo;

import java.util.Objects;

public class VToDoView extends AbstractComponentView {

    private final VToDo todo;

    public VToDoView(VToDo todo) {
        this.todo = todo;
    }

    public String getSummary() {
        return Objects.requireNonNull(todo.getSummary()).getValue();
    }

    public String getStatus() {
        return getStatusString(todo.getStatus());
    }

    public String getPriority() {
        return getPriorityString(todo.getPriority());
    }

    public String getPercentComplete() {
        return getPercentCompleteString(todo.getPercentComplete());
    }
}
