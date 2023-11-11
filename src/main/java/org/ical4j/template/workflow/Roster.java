package org.ical4j.template.workflow;

import net.fortuna.ical4j.model.component.VAvailability;
import org.ical4j.template.AbstractTemplate;

public class Roster extends AbstractTemplate<VAvailability> {

    public Roster() {
        super(VAvailability.class);
    }

    public Roster(Class<VAvailability> typeClass) {
        super(typeClass);
    }

    @Override
    public VAvailability apply(VAvailability vAvailability) {
        return vAvailability;
    }
}
