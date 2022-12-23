package org.ical4j.template.property;

import net.fortuna.ical4j.model.ParameterList;
import net.fortuna.ical4j.model.Recur;
import net.fortuna.ical4j.model.WeekDay;
import net.fortuna.ical4j.model.property.RRule;
import net.fortuna.ical4j.transform.recurrence.Frequency;
import org.threeten.extra.*;

import java.time.DayOfWeek;
import java.time.Month;
import java.time.temporal.Temporal;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Recurrence<T extends Temporal> extends RRule<T> {

    public Recurrence(Recur<T> aRecur) {
        super(aRecur);
    }

    public Recurrence(ParameterList aList, Recur<T> aRecur) {
        super(aList, aRecur);
    }

    /**
     * How often the recurrence repeats (i.e. interval).
     * @param interval
     * @return
     */
    public static <T extends Temporal> Recurrence<T> of(Years interval) {
        return new Recurrence<>(new Recur.Builder<T>().frequency(Frequency.YEARLY)
                .interval(interval.getAmount()).build());
    }

    /**
     * How often the recurrence repeats (i.e. interval).
     * @param interval
     * @return
     */
    public static <T extends Temporal> Recurrence<T> of(Months interval) {
        return new Recurrence<>(new Recur.Builder<T>().frequency(Frequency.MONTHLY)
                .interval(interval.getAmount()).build());
    }

    /**
     * How often the recurrence repeats (i.e. interval).
     * @param interval
     * @return
     */
    public static <T extends Temporal> Recurrence<T> of(Weeks interval) {
        return new Recurrence<>(new Recur.Builder<T>().frequency(Frequency.WEEKLY)
                .interval(interval.getAmount()).build());
    }

    /**
     * How often the recurrence repeats (i.e. interval).
     * @param interval
     * @return
     */
    public static <T extends Temporal> Recurrence<T> of(Days interval) {
        return new Recurrence<>(new Recur.Builder<T>().frequency(Frequency.DAILY)
                .interval(interval.getAmount()).build());
    }

    /**
     * How often the recurrence repeats (i.e. interval).
     * @param interval
     * @return
     */
    public static <T extends Temporal> Recurrence<T> of(Hours interval) {
        return new Recurrence<>(new Recur.Builder<T>().frequency(Frequency.HOURLY)
                .interval(interval.getAmount()).build());
    }

    /**
     * How often the recurrence repeats (i.e. interval).
     * @param interval
     * @return
     */
    public static <T extends Temporal> Recurrence<T> of(Minutes interval) {
        return new Recurrence<>(new Recur.Builder<T>().frequency(Frequency.MINUTELY)
                .interval(interval.getAmount()).build());
    }

    /**
     * How often the recurrence repeats (i.e. interval).
     * @param interval
     * @return
     */
    public static <T extends Temporal> Recurrence<T> of(Seconds interval) {
        return new Recurrence<>(new Recur.Builder<T>().frequency(Frequency.SECONDLY)
                .interval(interval.getAmount()).build());
    }

    /**
     * On which day of the week the recurrence repeats (BYDAY).
     * @param day
     * @return
     */
    public Recurrence<T> on(DayOfWeek... day) {
        return new Recurrence<>(getParameterList(), new Recur.Builder<T>(getRecur())
                .dayList(Arrays.stream(day).map(WeekDay::getWeekDay).collect(Collectors.toList())).build());
    }

    /**
     * On which day of the month the recurrence repeats (BYMONTHDAY).
     * @param dayOfMonth
     * @return
     */
    public Recurrence<T> on(Integer... dayOfMonth) {
        return new Recurrence<>(getParameterList(), new Recur.Builder<T>(getRecur())
                .monthDayList(Arrays.asList(dayOfMonth)).build());
    }

    public Recurrence<T> on(Month... month) {
        return new Recurrence<>(getParameterList(), new Recur.Builder<T>(getRecur())
                .monthList(Arrays.stream(month).map(m -> net.fortuna.ical4j.model.Month.valueOf(m.getValue()))
                        .collect(Collectors.toList())).build());
    }

    /**
     * The end date of the recurrence (i.e. until).
     * @param endDate
     * @return
     */
    public Recurrence<T> until(T endDate) {
        return new Recurrence<>(getParameterList(), new Recur.Builder<T>(getRecur())
                .until(endDate).build());
    }

    /**
     * The total number of occurrences (i.e. count).
     * @param count
     * @return
     */
    public Recurrence<T> occurrences(int count) {
        return new Recurrence<>(getParameterList(), new Recur.Builder<T>(getRecur())
                .count(count).build());
    }
}
