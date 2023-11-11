package org.ical4j.template.project;

import net.fortuna.ical4j.model.component.VJournal;
import org.ical4j.template.AbstractTemplate;

public class Timesheet extends AbstractTemplate<VJournal> {

    public Timesheet() {
        super(VJournal.class);
    }

    public Timesheet(Class<VJournal> typeClass) {
        super(typeClass);
    }

    @Override
    public VJournal apply(VJournal vJournal) {
        return vJournal;
    }
}
