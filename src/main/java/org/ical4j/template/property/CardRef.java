package org.ical4j.template.property;

import net.fortuna.ical4j.model.property.Contact;
import net.fortuna.ical4j.vcard.PropertyName;
import net.fortuna.ical4j.vcard.VCard;

/**
 * Use the {@link VCard} to populate the property.
 */
public class CardRef extends Contact {

    public CardRef(VCard card) {
        super(card.getRequiredProperty(PropertyName.N.toString()).getValue());
    }
}
