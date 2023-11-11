package org.ical4j.template.project;

import net.fortuna.ical4j.model.component.VToDo;
import org.ical4j.template.AbstractTemplate;

public class Task extends AbstractTemplate<VToDo> {

    public Task() {
        super(VToDo.class);
    }

    public Task(Class<VToDo> typeClass) {
        super(typeClass);
    }

    @Override
    public VToDo apply(VToDo vToDo) {
        return vToDo;
    }
}
