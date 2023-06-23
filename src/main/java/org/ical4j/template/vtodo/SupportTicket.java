package org.ical4j.template.vtodo;

import net.fortuna.ical4j.model.component.VToDo;
import net.fortuna.ical4j.model.property.Due;
import net.fortuna.ical4j.model.property.Summary;

import java.time.LocalDate;

/**
 * A support ticket workflow component with SLA requirements, etc.
 */
public class SupportTicket extends VToDo {

    public SupportTicket(String summary) {
        add(new Summary(summary));
    }

    SupportTicket withResolutionTarget(LocalDate resolutionTarget) {
        replace(new Due<>(resolutionTarget));
        return this;
    }

    SupportTicket withResolutionTarget(int numDays) {
        replace(new Due<>(LocalDate.now().plusDays(numDays)));
        return this;
    }
}
