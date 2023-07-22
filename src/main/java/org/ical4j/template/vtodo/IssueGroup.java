package org.ical4j.template.vtodo;

import net.fortuna.ical4j.model.PropertyList;
import net.fortuna.ical4j.model.component.VToDo;
import net.fortuna.ical4j.model.property.DtStamp;
import net.fortuna.ical4j.model.property.Summary;
import net.fortuna.ical4j.util.RandomUidGenerator;
import org.ical4j.template.AbstractCalendarTemplate;
import org.ical4j.template.property.Child;

import java.util.Arrays;

/**
 * Represents a group of {@link Issue}s required to complete a feature or larger
 * milestone.
 */
public class IssueGroup extends AbstractCalendarTemplate<VToDo> {

    public IssueGroup(String summary) {
        super(new VToDo(new PropertyList(Arrays.asList(new RandomUidGenerator().generateUid(),
                new DtStamp(), new Summary(summary)))));
    }

    @Override
    public <T extends AbstractCalendarTemplate<VToDo>> T getFluentTarget() {
        return (T) this;
    }

    public IssueGroup issue(Child issue) {
        getRevisions().getLatestRevision().add(issue);
        return this;
    }
}
