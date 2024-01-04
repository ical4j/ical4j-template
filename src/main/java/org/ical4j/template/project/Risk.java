package org.ical4j.template.project;

import net.fortuna.ical4j.model.component.VJournal;
import net.fortuna.ical4j.model.property.Status;
import net.fortuna.ical4j.model.property.StyledDescription;
import net.fortuna.ical4j.vcard.VCard;
import org.ical4j.template.AbstractTemplate;

/**
 * Used to identify potential issues relating to a project.
 */
public class Risk extends AbstractTemplate<VJournal> {

    private String title;

    private StyledDescription description;

    private StyledDescription impact;

    private StyledDescription mitigation;

    private VCard owner;

    private Status status;

    public Risk() {
        super(VJournal.class);
    }

    public Risk(Class<? extends VJournal> typeClass) {
        super(typeClass);
    }

    public <T extends VJournal> Risk(T prototype) {
        super(prototype.getClass());
        setPrototype(prototype);
    }

    @Override
    public VJournal apply(VJournal vJournal) {
        vJournal.replace(status);
        return vJournal;
    }
}
