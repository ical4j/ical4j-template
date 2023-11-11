package org.ical4j.template.groupware;

import net.fortuna.ical4j.model.component.VToDo;
import org.ical4j.template.AbstractTemplate;

/**
 * One or more objectives, typically linked to a Meeting to guide outcomes.
 */
public class Agenda extends AbstractTemplate<VToDo> {

    public Agenda() {
        super(VToDo.class);
    }

    public Agenda(Class<VToDo> typeClass) {
        super(typeClass);
    }

    @Override
    public VToDo apply(VToDo vToDo) {
        return vToDo;
    }
}
