package org.ical4j.template.view;

import net.fortuna.ical4j.model.component.VJournal;

import java.util.Objects;

public class VJournalView extends AbstractComponentView {

    private final VJournal journal;

    public VJournalView(VJournal journal) {
        this.journal = journal;
    }

    public String getSummary() {
        return Objects.requireNonNull(journal.getSummary()).getValue();
    }

    public String getStatus() {
        return getStatusString(journal.getStatus());
    }

    public String getClassification() {
        return getClassificationString(journal.getClassification());
    }
}
