package org.ical4j.template.wiki;

import net.fortuna.ical4j.model.component.VJournal;
import org.ical4j.template.AbstractTemplate;

public class Definition extends AbstractTemplate<VJournal> {

    public Definition() {
        super(VJournal.class);
    }

    public Definition(Class<VJournal> typeClass) {
        super(typeClass);
    }

    @Override
    public VJournal apply(VJournal vJournal) {
        return vJournal;
    }
}
