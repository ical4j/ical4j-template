package org.ical4j.template.agile;

import net.fortuna.ical4j.model.component.VToDo;
import org.ical4j.template.AbstractTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * A regular part of ceremonial meetings to reflect on how a project is tracking.
 */
public class Retrospective extends AbstractTemplate<VToDo> {

    private List<String> working = new ArrayList<>();

    private List<String> notWorking = new ArrayList<>();
    
    private List<String> confusing = new ArrayList<>();

    public Retrospective() {
        super(VToDo.class);
    }

    public Retrospective(Class<VToDo> typeClass) {
        super(typeClass);
    }

    @Override
    public VToDo apply(VToDo vToDo) {
        return vToDo;
    }
}
