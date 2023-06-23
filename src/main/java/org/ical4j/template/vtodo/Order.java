package org.ical4j.template.vtodo;

import net.fortuna.ical4j.model.component.VToDo;
import net.fortuna.ical4j.model.property.RelatedTo;
import net.fortuna.ical4j.model.property.Summary;
import org.ical4j.template.property.SchemaType;
import org.ical4j.template.vjournal.Offer;

/**
 * Represents an order of an {@link Offer}.
 */
public class Order extends VToDo {

    public Order(String summary) {
        add(new Summary(summary));
    }

    public Order offer(Offer offer) {
        add(new RelatedTo(offer));
        add(new SchemaType("Order", ""));
        return this;
    }
}
