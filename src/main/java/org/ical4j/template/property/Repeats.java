package org.ical4j.template.property;

import net.fortuna.ical4j.model.Recur;
import net.fortuna.ical4j.model.WeekDay;
import net.fortuna.ical4j.model.property.RRule;
import net.fortuna.ical4j.transform.recurrence.Frequency;
import org.threeten.extra.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.Temporal;
import java.util.Arrays;
import java.util.stream.Collectors;

import static java.time.DayOfWeek.*;

/**
 * Provides a simpler abstraction of iCalendar recurrence rules.
 *
 * @param <T> the temporal type to which this rule will be applied
 */
public class Repeats<T extends Temporal> extends RRule<T> {

    public static final Repeats<LocalDate> YEARLY = new Repeats<>(Years.ONE);

    public static final Repeats<LocalDate> HALF_YEARLY = new Repeats<>(Months.of(6));

    public static final Repeats<LocalDate> QUARTERLY = new Repeats<>(Months.of(3));

    public static final Repeats<LocalDate> MONTHLY = new Repeats<>(Months.ONE);

    public static final Repeats<LocalDate> FORTNIGHTLY  = new Repeats<>(Weeks.of(2));

    public static final Repeats<LocalDate> WEEKLY = new Repeats<>(Weeks.ONE);

    public static final Repeats<LocalDate> DAILY = new Repeats<>(Days.ONE);

    public static final Repeats<LocalDate> TWICE_DAILY = new Repeats<>(Hours.of(12));

    public static final Repeats<LocalDate> HOURLY = new Repeats<>(Hours.of(1));

    public static final Repeats<LocalDate> MINUTELY = new Repeats<>(Minutes.of(1));

    public static final Repeats<LocalDate> SECONDLY = new Repeats<>(Seconds.of(1));

    public static final Repeats<LocalDate> WEEKDAYS = new Repeats<LocalDate>(Weeks.ONE)
            .on(MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY);

    public static final Repeats<LocalDate> WEEKENDS = new Repeats<LocalDate>(Weeks.ONE)
            .on(SATURDAY, SUNDAY);

    /**
     * How often the recurrence repeats (i.e. interval).
     * @param interval
     */
    public Repeats(Years interval) {
        setRecur(new Recur.Builder<>(getRecur()).frequency(Frequency.YEARLY)
                .interval(interval.getAmount()).build());
    }

    /**
     * How often the recurrence repeats (i.e. interval).
     * @param interval
     */
    public Repeats(Months interval) {
        setRecur(new Recur.Builder<>(getRecur()).frequency(Frequency.MONTHLY)
                .interval(interval.getAmount()).build());
    }

    /**
     * How often the recurrence repeats (i.e. interval).
     * @param interval
     */
    public Repeats(Weeks interval) {
        setRecur(new Recur.Builder<>(getRecur()).frequency(Frequency.WEEKLY)
                .interval(interval.getAmount()).build());
    }

    /**
     * How often the recurrence repeats (i.e. interval).
     * @param interval
     */
    public Repeats(Days interval) {
        setRecur(new Recur.Builder<>(getRecur()).frequency(Frequency.DAILY)
                .interval(interval.getAmount()).build());
    }

    /**
     * How often the recurrence repeats (i.e. interval).
     * @param interval
     */
    public Repeats(Hours interval) {
        setRecur(new Recur.Builder<>(getRecur()).frequency(Frequency.HOURLY)
                .interval(interval.getAmount()).build());
    }

    /**
     * How often the recurrence repeats (i.e. interval).
     * @param interval
     */
    public Repeats(Minutes interval) {
        setRecur(new Recur.Builder<>(getRecur()).frequency(Frequency.MINUTELY)
                .interval(interval.getAmount()).build());
    }

    /**
     * How often the recurrence repeats (i.e. interval).
     * @param interval
     */
    public Repeats(Seconds interval) {
        setRecur(new Recur.Builder<>(getRecur()).frequency(Frequency.SECONDLY)
                .interval(interval.getAmount()).build());
    }

    /**
     * On which day of the week the recurrence repeats (BYDAY).
     * @param day
     */
    public Repeats<T> on(DayOfWeek... day) {
        setRecur(new Recur.Builder<>(getRecur()).dayList(Arrays.stream(day).map(WeekDay::getWeekDay)
                .collect(Collectors.toList())).build());
        return this;
    }

    /**
     * On which day of the month the recurrence repeats (BYMONTHDAY).
     * @param dayOfMonth
     */
    public Repeats<T> on(Integer... dayOfMonth) {
        setRecur(new Recur.Builder<>(getRecur()).monthDayList(Arrays.asList(dayOfMonth)).build());
        return this;
    }

    public Repeats<T> on(Month... month) {
        setRecur(new Recur.Builder<>(getRecur()).monthList(Arrays.stream(month)
                .map(m -> net.fortuna.ical4j.model.Month.valueOf(m.getValue()))
                        .collect(Collectors.toList())).build());
        return this;
    }

    /**
     * The end date of the recurrence (i.e. until).
     * @param endDate
     * @return
     */
    public Repeats<T> until(T endDate) {
        setRecur(new Recur.Builder<>(getRecur()).until(endDate).build());
        return this;
    }

    /**
     * The total number of occurrences (i.e. count).
     * @param count
     * @return
     */
    public Repeats<T> times(int count) {
        setRecur(new Recur.Builder<>(getRecur()).count(count).build());
        return this;
    }
}
