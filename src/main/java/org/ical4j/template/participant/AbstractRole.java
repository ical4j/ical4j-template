package org.ical4j.template.participant;

import net.fortuna.ical4j.model.component.Participant;
import net.fortuna.ical4j.model.property.CalendarAddress;
import net.fortuna.ical4j.model.property.ParticipantType;
import net.fortuna.ical4j.vcard.PropertyName;
import net.fortuna.ical4j.vcard.VCard;
import net.fortuna.ical4j.vcard.property.CalAdrUri;

public abstract class AbstractRole extends Participant {

    public AbstractRole(ParticipantType participantType) {
        add(participantType);
    }

    public AbstractRole(VCard card, ParticipantType participantType) {
        add(participantType);

        CalAdrUri calAdrUri = card.getRequiredProperty(PropertyName.CALADRURI.toString());
        add(new CalendarAddress(calAdrUri.getUri()));
    }
}
