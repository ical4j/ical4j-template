package org.ical4j.template.groupware;

import net.fortuna.ical4j.model.component.VEvent;
import org.ical4j.template.AbstractTemplate;

import java.net.URISyntaxException;
import java.time.ZonedDateTime;

import static net.fortuna.ical4j.model.DateTimePropertyModifiers.DTSTART;

public class Appointment extends AbstractTemplate<VEvent> {

    private ZonedDateTime start;

    public Appointment() {
        super(VEvent.class);
    }

    public Appointment(Class<? extends VEvent> typeClass) {
        super(typeClass);
    }

    public <T extends VEvent> Appointment(T prototype) {
        super(prototype.getClass());
        setPrototype(prototype);
    }

    public Appointment start(ZonedDateTime start) {
        this.start = start;
        return this;
    }

    @Override
    public VEvent apply(VEvent vEvent) {
        applyPrototype(vEvent);

        vEvent.with(DTSTART, start);
        return vEvent;
    }

    /**
     * Update the organizer for this appointment. Note there can only be ONE organizer so
     * this method will REPLACE any existing ORGANIZER properties.
     * @param organizer an organizer email address
     * @return this appointment instance
     * @throws URISyntaxException if the specified string is not a valid mailto: URI.
     */
//    Appointment withOrganizer(String organizer) throws URISyntaxException {
//        replace(new Organizer(organizer));
//        return this;
//    }
}
