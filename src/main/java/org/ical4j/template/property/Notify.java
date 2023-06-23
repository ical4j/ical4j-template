package org.ical4j.template.property;

import net.fortuna.ical4j.model.parameter.Related;
import net.fortuna.ical4j.model.property.Trigger;
import org.threeten.extra.Hours;
import org.threeten.extra.Minutes;

import java.time.Duration;

import static org.ical4j.template.property.Notify.Relative.*;

public class Notify extends Trigger {

    public static final Notify ON_START = new Notify(Duration.ZERO, AfterStart);
    
    public static final Notify ON_END = new Notify(Duration.ZERO, AfterEnd);

    public static final Notify ONE_HOUR_BEFORE_START = new Notify(Hours.of(1).toDuration(), BeforeStart);

    public static final Notify FIVE_MINUTES_BEFORE_END = new Notify(Minutes.of(5).toDuration(), BeforeEnd);

    public enum Relative { BeforeStart, AfterStart, BeforeEnd, AfterEnd }

    public Notify(Duration duration, Relative relative) {
        switch (relative) {
            case BeforeStart:
                replace(Related.START);
                setDuration(duration.negated());
                break;
            case AfterStart:
                replace(Related.START);
                setDuration(duration);
                break;
            case BeforeEnd:
                replace(Related.END);
                setDuration(duration.negated());
                break;
            case AfterEnd:
                replace(Related.END);
                setDuration(duration);
        }
    }
}
