package org.ical4j.template.groupware;

import net.fortuna.ical4j.model.component.VJournal;
import org.ical4j.template.AbstractTemplate;

public class Attendance extends AbstractTemplate<VJournal> {

    public Attendance() {
        super(VJournal.class);
    }

    public Attendance(Class<VJournal> typeClass) {
        super(typeClass);
    }

    @Override
    public VJournal apply(VJournal vJournal) {
        return vJournal;
    }
}
