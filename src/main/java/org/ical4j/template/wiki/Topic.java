package org.ical4j.template.wiki;

import net.fortuna.ical4j.model.component.VJournal;
import org.ical4j.template.AbstractTemplate;

public class Topic extends AbstractTemplate<VJournal> {

    public Topic() {
        super(VJournal.class);
    }

    public Topic(Class<VJournal> typeClass) {
        super(typeClass);
    }

    @Override
    public VJournal apply(VJournal vJournal) {
        return vJournal;
    }
}
