package org.ical4j.template.participant;

import net.fortuna.ical4j.model.property.immutable.ImmutableParticipantType;
import net.fortuna.ical4j.vcard.VCard;

public class ActiveRole extends AbstractRole {

    public ActiveRole() {
        super(ImmutableParticipantType.ACTIVE);
    }

    public ActiveRole(VCard card) {
        super(card, ImmutableParticipantType.ACTIVE);
    }
}
