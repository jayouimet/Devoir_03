package com.example.devoir3.obj.calendar;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Calendar {
    public List<CalendarYear> years;

    public Calendar() {
        years = new ArrayList<CalendarYear>();
        LocalDateTime date = LocalDateTime.now();
        int currentYear = date.getYear();
        years.add(new CalendarYear(currentYear - 1));
        years.add(new CalendarYear(currentYear));
        years.add(new CalendarYear(currentYear + 1));
    }

    public void AddEvent(CalendarEvent event, int year, int month, int day) {
        for (CalendarYear y: years) {
            if (y.yearNumber == year) {
                y.calendarMonths[month - 1].calendarDays.get(day - 1).events.add(event);
            }
        }
    }
}
