package com.example.devoir3.obj.calendar;

import java.util.List;

public class CalendarDay {
    public List<CalendarEvent> events;
    public int dayOfTheMonth;

    public CalendarDay(int day) {
        dayOfTheMonth = day;
    }
}
