package org.ical4j.template.project;

import net.fortuna.ical4j.model.component.VToDo;
import org.ical4j.template.AbstractTemplate;

public class Project extends AbstractTemplate<VToDo> {

    public Project() {
        super(VToDo.class);
    }

    public Project(Class<VToDo> typeClass) {
        super(typeClass);
    }

    @Override
    public VToDo apply(VToDo vToDo) {
        return vToDo;
    }
}
