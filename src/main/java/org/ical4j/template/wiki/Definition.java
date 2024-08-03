package org.ical4j.template.wiki;

import net.fortuna.ical4j.model.component.VJournal;
import org.ical4j.template.AbstractTemplate;

public class Definition extends AbstractTemplate<VJournal> {

    public Definition() {
        super(VJournal.class);
    }

    public Definition(Class<? extends VJournal> typeClass) {
        super(typeClass);
    }

    public <T extends VJournal> Definition(T prototype) {
        super(prototype.getClass());
        setPrototype(prototype);
    }

    @Override
    public VJournal apply(VJournal vJournal) {
        applyPrototype(vJournal);

        return vJournal;
    }
}
