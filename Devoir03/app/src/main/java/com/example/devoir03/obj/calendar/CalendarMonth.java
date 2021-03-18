package com.example.devoir03.obj.calendar;

import androidx.appcompat.app.AppCompatActivity;
import java.time.LocalDateTime;

public class CalendarMonth {
    public CalendarDay[] calendarDays;
    public int startingDay;
    public int month;

    public CalendarMonth(int m, int y) {
        LocalDateTime date = LocalDateTime.of(y, m, 1, 0, 0);
        month = m;
        startingDay = date.getDayOfWeek().getValue();
        int maxDaysInMonth = date.toLocalDate().lengthOfMonth();
        calendarDays = new CalendarDay[maxDaysInMonth];
        for (int i = 0; i < maxDaysInMonth; i++) {
            calendarDays[i] = new CalendarDay(i + 1);
        }
    }
}
