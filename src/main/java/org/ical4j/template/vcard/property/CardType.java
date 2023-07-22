package org.ical4j.template.vcard.property;

import net.fortuna.ical4j.model.property.ImmutableProperty;
import net.fortuna.ical4j.vcard.property.Categories;

/**
 * This class extends the {@link Categories} property to provide common categories applied to
 * vCard information.
 */
public class CardType extends Categories implements ImmutableProperty {

    public static final CardType CONTACT = new CardType("CONTACT");
    public static final CardType APPLICATION = new CardType("APPLICATION");

    public CardType(String... categories) {
        super(categories);
    }
}
