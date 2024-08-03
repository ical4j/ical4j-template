package org.ical4j.template.workflow;

import net.fortuna.ical4j.model.component.VToDo;
import org.ical4j.template.AbstractTemplate;

/**
 * Captures an approval step as part of a workflow.
 */
public class Approval extends AbstractTemplate<VToDo> {

    public Approval() {
        super(VToDo.class);
    }

    public Approval(Class<? extends VToDo> typeClass) {
        super(typeClass);
    }

    public <T extends VToDo> Approval(T prototype) {
        super(prototype.getClass());
        setPrototype(prototype);
    }

    @Override
    public VToDo apply(VToDo vToDo) {
        applyPrototype(vToDo);

        return vToDo;
    }
}
