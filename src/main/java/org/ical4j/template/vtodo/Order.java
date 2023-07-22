package org.ical4j.template.vtodo;

import net.fortuna.ical4j.model.PropertyList;
import net.fortuna.ical4j.model.component.VToDo;
import net.fortuna.ical4j.model.property.DtStamp;
import net.fortuna.ical4j.model.property.RelatedTo;
import net.fortuna.ical4j.model.property.Summary;
import net.fortuna.ical4j.util.RandomUidGenerator;
import org.ical4j.template.AbstractCalendarTemplate;
import org.ical4j.template.property.OrderDetails;
import org.ical4j.template.vjournal.Offer;

import java.util.Arrays;

/**
 * Represents an order of an {@link Offer}. Typically, an order is actionable via some fulfilment process.
 */
public class Order extends AbstractCalendarTemplate<VToDo> {

    public Order(String summary, OrderDetails orderDetails) {
        super(new VToDo(new PropertyList(Arrays.asList(new RandomUidGenerator().generateUid(),
                new DtStamp(), new Summary(summary), orderDetails))));
    }

    @Override
    public <T extends AbstractCalendarTemplate<VToDo>> T getFluentTarget() {
        return (T) this;
    }

    public Order offer(RelatedTo offer) {
        getRevisions().getLatestRevision().add(offer);
        return this;
    }
}
