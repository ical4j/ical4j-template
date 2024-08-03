package org.ical4j.template.project;

import net.fortuna.ical4j.model.component.VJournal;
import org.ical4j.template.AbstractTemplate;

public class Timesheet extends AbstractTemplate<VJournal> {

    public Timesheet() {
        super(VJournal.class);
    }

    public Timesheet(Class<? extends VJournal> typeClass) {
        super(typeClass);
    }

    public <T extends VJournal> Timesheet(T prototype) {
        super(prototype.getClass());
        setPrototype(prototype);
    }

    @Override
    public VJournal apply(VJournal vJournal) {
        applyPrototype(vJournal);

        return vJournal;
    }
}
