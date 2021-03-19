package com.example.devoir3.obj.calendar;

import java.util.ArrayList;
import java.util.List;

public class CalendarDay {
    public List<CalendarEvent> events;
    public int dayOfTheMonth;

    /**
     * Constructeur paramétré
     * @param day Le numéro de jour
     */
    public CalendarDay(int day) {
        dayOfTheMonth = day;
        events = new ArrayList<>();
    }
}
