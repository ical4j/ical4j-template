package org.ical4j.template.agile;

import net.fortuna.ical4j.model.component.VJournal;
import org.ical4j.template.AbstractTemplate;

/**
 * A requirement or feature definition that documents what needs to be done. Analogous to a User Story.
 */
public class Criteria extends AbstractTemplate<VJournal> {

    public Criteria() {
        super(VJournal.class);
    }

    public Criteria(Class<VJournal> typeClass) {
        super(typeClass);
    }

    @Override
    public VJournal apply(VJournal vJournal) {
        return vJournal;
    }
}
