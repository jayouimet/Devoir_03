package com.example.devoir3.obj.calendar;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CalendarMonth {
    public List<CalendarDay> calendarDays;
    public int startingDay;
    public int month;

    public CalendarMonth(int m, int y) {
        LocalDateTime date = LocalDateTime.of(y, m, 1, 0, 0);
        month = m;
        startingDay = date.getDayOfWeek().getValue();
        int maxDaysInMonth = date.toLocalDate().lengthOfMonth();
        calendarDays = new ArrayList<>();
        for (int i = 0; i < maxDaysInMonth; i++) {
            calendarDays.add(new CalendarDay(i + 1));
        }
    }
}
