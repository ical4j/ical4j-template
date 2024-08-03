package org.ical4j.template.agile;

import net.fortuna.ical4j.model.component.VToDo;
import org.ical4j.template.AbstractTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * A regular part of ceremonial meetings to reflect on how a project is tracking.
 */
public class Retrospective extends AbstractTemplate<VToDo> {

    private List<VToDo> working = new ArrayList<>();

    private List<VToDo> notWorking = new ArrayList<>();
    
    private List<VToDo> confusing = new ArrayList<>();

    public Retrospective() {
        super(VToDo.class);
    }

    public Retrospective(Class<? extends VToDo> typeClass) {
        super(typeClass);
    }

    public <T extends VToDo> Retrospective(T prototype) {
        super(prototype.getClass());
        setPrototype(prototype);
    }

    @Override
    public VToDo apply(VToDo vToDo) {
        applyPrototype(vToDo);

        return vToDo;
    }
}
