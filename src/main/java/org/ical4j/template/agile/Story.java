package org.ical4j.template.agile;

import net.fortuna.ical4j.model.component.VToDo;
import org.ical4j.template.AbstractTemplate;

/**
 * A work item to implement an independent feature or requirement as defined by associated acceptance Criteria.
 */
public class Story extends AbstractTemplate<VToDo> {

    public Story() {
        super(VToDo.class);
    }

    public Story(Class<VToDo> typeClass) {
        super(typeClass);
    }

    @Override
    public VToDo apply(VToDo vToDo) {
        return vToDo;
    }
}
