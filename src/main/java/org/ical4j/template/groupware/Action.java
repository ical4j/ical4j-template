package org.ical4j.template.groupware;

import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.component.VToDo;
import org.ical4j.template.AbstractTemplate;

import java.time.LocalDate;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.List;

/**
 * This represents an action undertaken by an actor in response to a related component.
 * Typically, actions are chained together to form a workflow.
 *
 * See: <a href="https://schema.org/Action">Action</a>
 */
public class Action extends AbstractTemplate<VToDo> {

    private LocalDate due;

    private List<Component> dependencies = new ArrayList<>();

    public Action() {
        super(VToDo.class);
    }

    public Action(Class<VToDo> typeClass) {
        super(typeClass);
    }

    public Action due(LocalDate due) {
        this.due = due;
        return this;
    }

    public Action due(TemporalAmount due) {
        this.due = LocalDate.now().plus(due);
        return this;
    }

    public Action dependsOn(Component component) {
        dependencies.add(component);
        return this;
    }

    @Override
    public VToDo apply(VToDo vToDo) {
        return vToDo;
    }
}
