package org.ical4j.template.participant;

import net.fortuna.ical4j.model.property.immutable.ImmutableParticipantType;
import net.fortuna.ical4j.vcard.VCard;

public class InactiveRole extends AbstractRole {

    public InactiveRole() {
        super(ImmutableParticipantType.INACTIVE);
    }

    public InactiveRole(VCard card) {
        super(card, ImmutableParticipantType.ACTIVE);
    }
}
