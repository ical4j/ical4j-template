package org.ical4j.template.property;

import net.fortuna.ical4j.model.property.ImmutableProperty;
import net.fortuna.ical4j.vcard.property.Categories;

public class CardType extends Categories implements ImmutableProperty {

    public static final CardType CONTACT = new CardType("CONTACT");
    
    public CardType(String... categories) {
        super(categories);
    }
}
