package org.ical4j.template.vtodo;

import net.fortuna.ical4j.model.component.VToDo;
import net.fortuna.ical4j.model.property.Due;
import net.fortuna.ical4j.model.property.Summary;
import org.ical4j.template.property.ComponentType;
import org.ical4j.template.property.Parent;
import org.ical4j.template.vevent.Timebox;

import java.time.LocalDate;

/**
 * Creates an optionally recurring {@link VToDo} representing a task.
 */
public class Task extends VToDo {

    public Task(String summary, LocalDate due) {
        add(ComponentType.TASK);
        add(new Summary(summary));
        add(new Due<>(due));
    }

    public Task timebox(Timebox timebox) {
        add(new Parent(timebox));
        return this;
    }
}
