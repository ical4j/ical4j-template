package org.ical4j.template.wiki;

import net.fortuna.ical4j.model.component.VToDo;
import org.ical4j.template.AbstractTemplate;

public class Faq extends AbstractTemplate<VToDo> {

    public Faq() {
        super(VToDo.class);
    }

    public Faq(Class<? extends VToDo> typeClass) {
        super(typeClass);
    }

    public <T extends VToDo> Faq(T prototype) {
        super(prototype.getClass());
        setPrototype(prototype);
    }

    @Override
    public VToDo apply(VToDo vToDo) {
        applyPrototype(vToDo);

        return vToDo;
    }
}
