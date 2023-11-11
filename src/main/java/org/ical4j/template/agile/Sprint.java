package org.ical4j.template.agile;

import net.fortuna.ical4j.model.component.VEvent;
import org.ical4j.template.AbstractTemplate;

/**
 * A timeboxed team-focused effort to achieve completion of work items in an associated Backlog.
 */
public class Sprint extends AbstractTemplate<VEvent> {

    public Sprint() {
        super(VEvent.class);
    }

    public Sprint(Class<VEvent> typeClass) {
        super(typeClass);
    }

    @Override
    public VEvent apply(VEvent vEvent) {
        return vEvent;
    }
}
