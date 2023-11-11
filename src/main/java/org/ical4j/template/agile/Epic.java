package org.ical4j.template.agile;

import net.fortuna.ical4j.model.component.VToDo;
import org.ical4j.template.AbstractTemplate;

/**
 * A group of work items that achive a specific feature or goal.
 */
public class Epic extends AbstractTemplate<VToDo> {

    public Epic() {
        super(VToDo.class);
    }

    public Epic(Class<VToDo> typeClass) {
        super(typeClass);
    }

    @Override
    public VToDo apply(VToDo vToDo) {
        return vToDo;
    }
}
