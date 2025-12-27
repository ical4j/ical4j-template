package org.ical4j.template.view;

import net.fortuna.ical4j.model.component.VJournal;

public class VJournalView extends AbstractComponentView implements DescriptivePropertyView<VJournal>,
    ChangeManagementPropertyView<VJournal> {

    private final VJournal journal;

    public VJournalView(VJournal journal) {
        this.journal = journal;
    }

    @Override
    public VJournal getPropertyAccessor() {
        return journal;
    }

    public String toString() {
        return "Journal: " + getSummary() + "\n" +
                "Created: " + getCreated() + "\n" +
                "Last Modified: " + getLastModified() + "\n";
    }
}
