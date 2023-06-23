package org.ical4j.template.vjournal;

import net.fortuna.ical4j.model.component.VJournal;
import net.fortuna.ical4j.model.property.Summary;
import org.ical4j.template.property.SchemaType;
import org.ical4j.template.vcard.ProductDefinition;
import org.ical4j.template.vcard.ServiceDefinition;
import org.ical4j.template.vresource.ExternalRef;

/**
 * Typically, an offering would include details such as the quantity, availability, price, etc.
 */
public class Offer extends VJournal {

    public Offer(String summary) {
        add(new Summary(summary));
    }

    public Offer product(ProductDefinition product) {
        add(new ExternalRef(product));
        add(new SchemaType("Offer", ""));
        return this;
    }

    public Offer serviceDefinition(ServiceDefinition serviceDefinition) {
        add(new ExternalRef(serviceDefinition));
        add(new SchemaType("Offer", ""));
        return this;
    }
}
