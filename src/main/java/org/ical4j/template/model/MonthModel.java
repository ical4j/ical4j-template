package org.ical4j.template.model;

import java.time.Month;

public class MonthModel {

    private Month month;

    private int year;

    private char emptyChar;

    public MonthModel(Month month, int year, char emptyChar) {
        this.month = month;
        this.year = year;
        this.emptyChar = emptyChar;
    }

    public String getCell(int monthWeek, int dayOfWeek) {
        // Calculate the day of month based on monthWeek and dayOfWeek
        int dayOfMonth = (monthWeek - 1) * 7 + dayOfWeek;
        int daysInMonth = month.length(java.time.Year.isLeap(year));

        if (dayOfMonth < 1 || dayOfMonth > daysInMonth) {
            return String.valueOf(emptyChar);
        } else {
            return String.valueOf(dayOfMonth);
        }

    }

}
