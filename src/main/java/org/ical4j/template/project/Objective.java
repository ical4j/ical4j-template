package org.ical4j.template.project;

import net.fortuna.ical4j.model.component.VJournal;
import org.ical4j.template.AbstractTemplate;

public class Objective extends AbstractTemplate<VJournal> {

    public Objective() {
        super(VJournal.class);
    }

    public Objective(Class<? extends VJournal> typeClass) {
        super(typeClass);
    }

    public <T extends VJournal> Objective(T prototype) {
        super(prototype.getClass());
        setPrototype(prototype);
    }

    @Override
    public VJournal apply(VJournal vJournal) {
        applyPrototype(vJournal);

        return vJournal;
    }
}
