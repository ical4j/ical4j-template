package org.ical4j.template.property;

import net.fortuna.ical4j.model.parameter.Related;
import net.fortuna.ical4j.model.property.Trigger;
import org.threeten.extra.Hours;
import org.threeten.extra.Minutes;

import java.time.Duration;

public class Notify extends Trigger {

    public static final Notify ON_START = new Notify().afterStart(Duration.ZERO);
    
    public static final Notify ON_END = new Notify().afterEnd(Duration.ZERO);

    public static final Notify ONE_HOUR_BEFORE_START = new Notify().beforeStart(Hours.of(1).toDuration());

    public static final Notify FIVE_MINUTES_BEFORE_END = new Notify().beforeEnd(Minutes.of(5).toDuration());

    public Notify beforeStart(Duration duration) {
        replace(Related.START);
        setDuration(duration.negated());
        return this;
    }

    public Notify afterStart(Duration duration) {
        replace(Related.START);
        setDuration(duration);
        return this;
    }

    public Notify beforeEnd(Duration duration) {
        replace(Related.END);
        setDuration(duration.negated());
        return this;
    }

    public Notify afterEnd(Duration duration) {
        replace(Related.END);
        setDuration(duration);
        return this;
    }
}
