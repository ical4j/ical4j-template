package org.ical4j.template.agile;

import net.fortuna.ical4j.model.component.VToDo;
import org.ical4j.template.AbstractTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * A collection of work items, typically associated with a Sprint or higher level objective.
 */
public class Backlog extends AbstractTemplate<VToDo> {

    private List<VToDo> stories = new ArrayList<>();

    public Backlog() {
        super(VToDo.class);
    }

    public Backlog(Class<? extends VToDo> typeClass) {
        super(typeClass);
    }

    public <T extends VToDo> Backlog(T prototype) {
        super(prototype.getClass());
        setPrototype(prototype);
    }

    @Override
    public VToDo apply(VToDo vToDo) {
        return vToDo;
    }
}
