package org.ical4j.template.component;

import net.fortuna.ical4j.model.ComponentList;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.PropertyList;
import net.fortuna.ical4j.model.Recur;
import net.fortuna.ical4j.model.component.VAlarm;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.DtStart;
import net.fortuna.ical4j.model.property.RRule;
import net.fortuna.ical4j.model.property.Summary;
import net.fortuna.ical4j.model.property.immutable.ImmutableTransp;
import net.fortuna.ical4j.transform.recurrence.Frequency;

import java.time.LocalDate;
import java.time.MonthDay;
import java.time.Year;
import java.util.Arrays;
import java.util.List;

/**
 * Creates an annually recurring {@link VEvent} representing a birthday/anniversary.
 */
public class Anniversary extends VEvent {

    public Anniversary withTitle(String title) {
        replace(new Summary(title));
        return this;
    }

    public Anniversary withMonthDay(MonthDay monthDay) {
        replace(new DtStart<>(monthDay.atYear(Year.now().getValue())));
        return this;
    }

    public static class Factory extends VEvent.Factory {
        @Override
        public VEvent createComponent() {
            List<Property> props = Arrays.asList(
                    new RRule<>(new Recur.Builder<LocalDate>().frequency(Frequency.YEARLY).build()),
                    ImmutableTransp.TRANSPARENT);
            return super.createComponent(new PropertyList(props));
        }

        @Override
        public VEvent createComponent(PropertyList properties) {
            PropertyList props = (PropertyList) properties.add(new RRule<>(
                    new Recur.Builder<LocalDate>().frequency(Frequency.YEARLY).build()))
                    .add(ImmutableTransp.TRANSPARENT);
            return super.createComponent(props);
        }

        @Override
        public VEvent createComponent(PropertyList properties, ComponentList<?> subComponents) {
            PropertyList props = (PropertyList) properties.add(new RRule<>(
                    new Recur.Builder<LocalDate>().frequency(Frequency.YEARLY).build()))
                    .add(ImmutableTransp.TRANSPARENT);
            return new VEvent(properties, (ComponentList<VAlarm>) subComponents);
        }
    }
}
