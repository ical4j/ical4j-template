package org.ical4j.template.project;

import net.fortuna.ical4j.model.component.VJournal;
import net.fortuna.ical4j.model.property.Status;
import net.fortuna.ical4j.model.property.StyledDescription;
import org.ical4j.template.AbstractTemplate;

/**
 * Used to capture a significant decision relating to a project. In the software architecture domain this
 * is known as an Architecture Decision Record (ADR), or in project management a Key Decision Document (KDD),
 * but ultimately the goal is the same: to capture a decision along with reasons and status
 * (i.e. proposed, accepted, superseded).
 */
public class Decision extends AbstractTemplate<VJournal> {

    private String title;

    private StyledDescription context;

    private StyledDescription decision;

    private StyledDescription consequences;

    private Decision supersedes;

    private Status status;

    public Decision() {
        super(VJournal.class);
    }

    public Decision(Class<? extends VJournal> typeClass) {
        super(typeClass);
    }

    public <T extends VJournal> Decision(T prototype) {
        super(prototype.getClass());
        setPrototype(prototype);
    }

    @Override
    public VJournal apply(VJournal vJournal) {
        vJournal.replace(status);
        return vJournal;
    }
}
