package org.ical4j.template.agile;

import net.fortuna.ical4j.model.component.VToDo;
import org.ical4j.template.AbstractTemplate;

/**
 * A collection of work items, typically associated with a Sprint or higher level objective.
 */
public class Backlog extends AbstractTemplate<VToDo> {

    public Backlog() {
        super(VToDo.class);
    }

    public Backlog(Class<VToDo> typeClass) {
        super(typeClass);
    }

    @Override
    public VToDo apply(VToDo vToDo) {
        return vToDo;
    }
}
