package org.ical4j.template.project;

import net.fortuna.ical4j.model.component.VJournal;
import org.ical4j.template.AbstractTemplate;

public class Objective extends AbstractTemplate<VJournal> {

    public Objective() {
        super(VJournal.class);
    }

    public Objective(Class<VJournal> typeClass) {
        super(typeClass);
    }

    @Override
    public VJournal apply(VJournal vJournal) {
        return vJournal;
    }
}
