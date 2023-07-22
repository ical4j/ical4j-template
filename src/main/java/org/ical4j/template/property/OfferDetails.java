package org.ical4j.template.property;

import net.fortuna.ical4j.model.parameter.Schema;
import net.fortuna.ical4j.model.property.StructuredData;

import java.net.URI;

/**
 * Domain-specific details for an {@link org.ical4j.template.vjournal.Offer} instance. For example,
 * this could include a detailed list of options and add-ons for an offer.
 */
public class OfferDetails extends StructuredData {

    public OfferDetails(String aValue) {
        super(aValue);
        add(new Schema(URI.create("https://schema.org/Offer")));
    }
}
