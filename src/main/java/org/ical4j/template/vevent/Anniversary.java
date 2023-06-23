package org.ical4j.template.vevent;

import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.DtStart;
import net.fortuna.ical4j.model.property.Summary;
import net.fortuna.ical4j.model.property.immutable.ImmutableTransp;
import org.ical4j.template.property.Repeats;

import java.time.LocalDate;

/**
 * Creates a recurring {@link VEvent} representing a birthday/anniversary, etc.
 */
public class Anniversary extends VEvent {

    public Anniversary(String summary, LocalDate date) {
        add(ImmutableTransp.TRANSPARENT);
        add(new Summary(summary));
        add(new DtStart<>(date));
        add(Repeats.YEARLY);
    }

//    public static class Factory extends VEvent.Factory {
//        @Override
//        public VEvent createComponent() {
//            return super.createComponent(initProps());
//        }
//
//        @Override
//        public VEvent createComponent(PropertyList properties) {
//            return super.createComponent(initProps());
//        }
//
//        @Override
//        public VEvent createComponent(PropertyList properties, ComponentList<?> subComponents) {
//            return new VEvent(initProps(), (ComponentList<VAlarm>) subComponents);
//        }
//    }
}
