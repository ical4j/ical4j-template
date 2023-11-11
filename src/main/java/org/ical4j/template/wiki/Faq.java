package org.ical4j.template.wiki;

import net.fortuna.ical4j.model.component.VToDo;
import org.ical4j.template.AbstractTemplate;

public class Faq extends AbstractTemplate<VToDo> {

    public Faq() {
        super(VToDo.class);
    }

    public Faq(Class<VToDo> typeClass) {
        super(typeClass);
    }

    @Override
    public VToDo apply(VToDo vToDo) {
        return vToDo;
    }
}
