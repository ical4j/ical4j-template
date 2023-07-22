package org.ical4j.template.property;

import net.fortuna.ical4j.model.component.Participant;
import net.fortuna.ical4j.model.parameter.Role;
import net.fortuna.ical4j.model.property.Attendee;
import net.fortuna.ical4j.vcard.VCard;
import org.ical4j.template.participant.ActiveRole;

import java.net.URI;

public class Chair extends Attendee {

    public Chair(URI aUri) {
        super(aUri);
        add(Role.CHAIR);
    }

    public Chair(VCard card) {
        this(new ActiveRole(card));
    }

    public Chair(Participant participant) {
        super(participant);
        add(Role.CHAIR);
    }
}
