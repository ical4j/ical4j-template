package org.ical4j.template.project;

import net.fortuna.ical4j.model.component.VToDo;
import org.ical4j.template.AbstractTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a project milestone, which may consist of one or more child tasks.
 */
public class Milestone extends AbstractTemplate<VToDo> {

    private List<VToDo> tasks = new ArrayList<>();

    public Milestone() {
        super(VToDo.class);
    }

    public Milestone(Class<? extends VToDo> typeClass) {
        super(typeClass);
    }

    public <T extends VToDo> Milestone(T prototype) {
        super(prototype.getClass());
        setPrototype(prototype);
    }

    @Override
    public VToDo apply(VToDo vToDo) {
        return vToDo;
    }
}
