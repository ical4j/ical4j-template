package org.ical4j.template;

import net.fortuna.ical4j.model.component.CalendarComponent;
import net.fortuna.ical4j.model.property.Sequence;

public interface FluentCalendarTemplate<C extends CalendarComponent> {

    <T extends AbstractCalendarTemplate<C>> T getFluentTarget();

    default FluentCalendarTemplate<C> withRevision() {
        C newRevision = getFluentTarget().getRevisions().getLatestRevision().copy();
        newRevision.add(new Sequence(1));
        getFluentTarget().getRevisions().add(newRevision);
        return getFluentTarget();
    }
}
