package org.ical4j.template.vtodo;

import net.fortuna.ical4j.model.component.VToDo;
import net.fortuna.ical4j.model.property.RelatedTo;
import org.ical4j.template.property.SchemaType;
import org.ical4j.template.vjournal.Offer;

public class Invoice extends VToDo {

    public Invoice(Offer offer) {
        add(new RelatedTo(offer));
        add(new SchemaType("Invoice", ""));
    }
}
