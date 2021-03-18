package com.example.devoir03.obj.calendar;

public class CalendarYear {
    public int yearNumber;
    public CalendarMonth[] calendarMonths;

    public CalendarYear(int year) {
        yearNumber = year;
        calendarMonths = new CalendarMonth[12];
        for (int i = 0; i < 12; i++) {
            calendarMonths[i] = new CalendarMonth(i + 1, yearNumber);
        }
    }
}
