package org.ical4j.template.wiki;

import net.fortuna.ical4j.model.component.VJournal;
import org.ical4j.template.AbstractTemplate;

public class Topic extends AbstractTemplate<VJournal> {

    public Topic() {
        super(VJournal.class);
    }

    public Topic(Class<? extends VJournal> typeClass) {
        super(typeClass);
    }

    public <T extends VJournal> Topic(T prototype) {
        super(prototype.getClass());
        setPrototype(prototype);
    }

    @Override
    public VJournal apply(VJournal vJournal) {
        applyPrototype(vJournal);

        return vJournal;
    }
}
