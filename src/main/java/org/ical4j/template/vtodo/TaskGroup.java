package org.ical4j.template.vtodo;

import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.component.VToDo;
import net.fortuna.ical4j.model.property.RelatedTo;
import net.fortuna.ical4j.model.property.Summary;
import org.ical4j.template.property.Child;

/**
 * Represents a group of {@link Task}s required to complete a feature or larger
 * milestone.
 */
public class TaskGroup extends VToDo {

    public TaskGroup(String summary) {
        add(new Summary(summary));
    }

    public TaskGroup task(Task task) {
        add(new Child(task));
        return this;
    }
}
