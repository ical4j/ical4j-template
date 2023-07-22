package org.ical4j.template.property;

import net.fortuna.ical4j.model.parameter.Schema;
import net.fortuna.ical4j.model.property.StructuredData;

import java.net.URI;

/**
 * Domain-specific details for an {@link org.ical4j.template.vjournal.Invoice} instance. For example,
 * this may include details of payment options and an itemised list of services.
 */
public class InvoiceDetails extends StructuredData {

    public InvoiceDetails(String aValue) {
        super(aValue);
        add(new Schema(URI.create("https://schema.org/Invoice")));
    }
}
