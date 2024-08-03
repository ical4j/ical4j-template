package org.ical4j.template.project;

import net.fortuna.ical4j.model.component.VToDo;
import org.ical4j.template.AbstractTemplate;

public class Task extends AbstractTemplate<VToDo> {

    public Task() {
        super(VToDo.class);
    }

    public Task(Class<? extends VToDo> typeClass) {
        super(typeClass);
    }

    public <T extends VToDo> Task(T prototype) {
        super(prototype.getClass());
        setPrototype(prototype);
    }

    @Override
    public VToDo apply(VToDo vToDo) {
        applyPrototype(vToDo);

        return vToDo;
    }
}
