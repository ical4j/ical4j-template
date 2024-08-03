package org.ical4j.template.agile;

import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.component.VToDo;
import org.ical4j.template.AbstractTemplate;

/**
 * A timeboxed team-focused effort to achieve completion of work items in an associated Backlog.
 */
public class Sprint extends AbstractTemplate<VEvent> {

    private VToDo backlog;

    public Sprint() {
        super(VEvent.class);
    }

    public Sprint(Class<? extends VEvent> typeClass) {
        super(typeClass);
    }

    public <T extends VEvent> Sprint(T prototype) {
        super(prototype.getClass());
        setPrototype(prototype);
    }

    @Override
    public VEvent apply(VEvent vEvent) {
        applyPrototype(vEvent);

        return vEvent;
    }
}
