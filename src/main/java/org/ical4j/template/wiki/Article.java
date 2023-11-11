package org.ical4j.template.wiki;

import net.fortuna.ical4j.model.component.VJournal;
import org.ical4j.template.AbstractTemplate;

/**
 * Used to track a knowledge base article produced as part of a service management workflow.
 */
public class Article extends AbstractTemplate<VJournal> {

    public Article() {
        super(VJournal.class);
    }

    public Article(Class<VJournal> typeClass) {
        super(typeClass);
    }

    @Override
    public VJournal apply(VJournal vJournal) {
        return vJournal;
    }
}
