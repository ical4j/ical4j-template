package org.ical4j.template.participant;

import net.fortuna.ical4j.model.property.immutable.ImmutableParticipantType;
import net.fortuna.ical4j.vcard.VCard;

public class Contact extends AbstractRole {

    public Contact() {
        super(ImmutableParticipantType.CONTACT);
    }

    public Contact(VCard card) {
        super(card, ImmutableParticipantType.CONTACT);
    }
}
