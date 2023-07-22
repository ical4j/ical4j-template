package org.ical4j.template.vjournal;

import net.fortuna.ical4j.model.PropertyList;
import net.fortuna.ical4j.model.component.VJournal;
import net.fortuna.ical4j.model.property.DtStamp;
import net.fortuna.ical4j.model.property.RelatedTo;
import net.fortuna.ical4j.util.RandomUidGenerator;
import org.ical4j.template.AbstractCalendarTemplate;
import org.ical4j.template.property.InvoiceDetails;

import java.util.Arrays;

/**
 * This class represents an invoice for an {@link Offer} purchase.
 */
public class Invoice extends AbstractCalendarTemplate<VJournal> {

    public Invoice(RelatedTo offer, InvoiceDetails invoiceDetails) {
        super(new VJournal(new PropertyList(Arrays.asList(new RandomUidGenerator().generateUid(),
                new DtStamp(), offer, invoiceDetails))));
    }

    @Override
    public <T extends AbstractCalendarTemplate<VJournal>> T getFluentTarget() {
        return (T) this;
    }
}
