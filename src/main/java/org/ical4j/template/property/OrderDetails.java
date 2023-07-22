package org.ical4j.template.property;

import net.fortuna.ical4j.model.parameter.Schema;
import net.fortuna.ical4j.model.property.StructuredData;

import java.net.URI;

/**
 * Domain-specific details for an {@link org.ical4j.template.vtodo.Order} instance. For example,
 * this could include delivery details or account information for a related system.
 */
public class OrderDetails extends StructuredData {

    public OrderDetails(String aValue) {
        super(aValue);
        add(new Schema(URI.create("https://schema.org/Order")));
    }
}
