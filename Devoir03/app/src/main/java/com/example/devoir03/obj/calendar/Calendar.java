package com.example.devoir03.obj.calendar;

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
}
