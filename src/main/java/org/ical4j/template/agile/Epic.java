package org.ical4j.template.agile;

import net.fortuna.ical4j.model.component.VToDo;
import org.ical4j.template.AbstractTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * A group of work items that achive a specific feature or goal.
 */
public class Epic extends AbstractTemplate<VToDo> {
    
    private List<VToDo> stories = new ArrayList<>();

    public Epic() {
        super(VToDo.class);
    }

    public Epic(Class<? extends VToDo> typeClass) {
        super(typeClass);
    }

    public <T extends VToDo> Epic(T prototype) {
        super(prototype.getClass());
        setPrototype(prototype);
    }

    @Override
    public VToDo apply(VToDo vToDo) {
        return vToDo;
    }
}
