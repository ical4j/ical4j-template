package org.ical4j.template.vjournal;

import net.fortuna.ical4j.model.PropertyList;
import net.fortuna.ical4j.model.component.VJournal;
import net.fortuna.ical4j.model.property.DtStamp;
import net.fortuna.ical4j.model.property.Summary;
import net.fortuna.ical4j.util.RandomUidGenerator;
import org.ical4j.template.AbstractCalendarTemplate;
import org.ical4j.template.property.OfferDetails;
import org.ical4j.template.vresource.ExternalRef;

import java.util.Arrays;

/**
 * Typically, an offering would include details such as the quantity, availability, price, etc.
 */
public class Offer extends AbstractCalendarTemplate<VJournal> {

    public Offer(String summary, OfferDetails offerDetails) {
        super(new VJournal(new PropertyList(Arrays.asList(new RandomUidGenerator().generateUid(),
                new DtStamp(), new Summary(summary), offerDetails))));
    }

    @Override
    public <T extends AbstractCalendarTemplate<VJournal>> T getFluentTarget() {
        return (T) this;
    }

    public Offer product(ExternalRef product) {
        getRevisions().getLatestRevision().add(product);
        return this;
    }

    public Offer serviceDefinition(ExternalRef serviceDefinition) {
        getRevisions().getLatestRevision().add(serviceDefinition);
        return this;
    }
}
