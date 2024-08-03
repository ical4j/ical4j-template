package org.ical4j.template.project;

import net.fortuna.ical4j.model.component.VJournal;
import net.fortuna.ical4j.model.component.VToDo;
import org.ical4j.template.AbstractTemplate;

import java.util.ArrayList;
import java.util.List;

public class Project extends AbstractTemplate<VToDo> {

    private List<VJournal> objectives = new ArrayList<>();

    private List<VToDo> milestones = new ArrayList<>();

    private List<VToDo> tasks = new ArrayList<>();

    private List<VJournal> risks = new ArrayList<>();

    private List<VToDo> issues = new ArrayList<>();

    public Project() {
        super(VToDo.class);
    }

    public Project(Class<? extends VToDo> typeClass) {
        super(typeClass);
    }

    public <T extends VToDo> Project(T prototype) {
        super(prototype.getClass());
        setPrototype(prototype);
    }

    @Override
    public VToDo apply(VToDo vToDo) {
        applyPrototype(vToDo);

        return vToDo;
    }
}
