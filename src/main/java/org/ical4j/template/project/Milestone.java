package org.ical4j.template.project;

import net.fortuna.ical4j.model.component.VToDo;
import org.ical4j.template.AbstractTemplate;

/**
 * This class represents a project milestone, which may consist of one or more child tasks.
 */
public class Milestone extends AbstractTemplate<VToDo> {

    public Milestone() {
        super(VToDo.class);
    }

    public Milestone(Class<VToDo> typeClass) {
        super(typeClass);
    }

    @Override
    public VToDo apply(VToDo vToDo) {
        return vToDo;
    }
}
