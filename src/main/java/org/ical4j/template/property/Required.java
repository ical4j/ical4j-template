package org.ical4j.template.property;

import net.fortuna.ical4j.model.component.Participant;
import net.fortuna.ical4j.model.parameter.Role;
import net.fortuna.ical4j.model.property.Attendee;
import net.fortuna.ical4j.vcard.VCard;
import org.ical4j.template.participant.ActiveRole;

import java.net.URI;

public class Required extends Attendee {

    public Required(URI aUri) {
        super(aUri);
        add(Role.REQ_PARTICIPANT);
    }

    public Required(VCard card) {
        this(new ActiveRole(card));
    }

    public Required(Participant participant) {
        super(participant);
        add(Role.REQ_PARTICIPANT);
    }
}
