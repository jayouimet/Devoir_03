package com.example.devoir3.obj.calendar;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Calendar {
    public List<CalendarYear> years;

    /**
     * Constructeur par défaut
     */
    public Calendar() {
        years = new ArrayList<CalendarYear>();
        LocalDateTime date = LocalDateTime.now();
        int currentYear = date.getYear();
        years.add(new CalendarYear(currentYear - 1));
        years.add(new CalendarYear(currentYear));
        years.add(new CalendarYear(currentYear + 1));
    }

    /**
     * Ajout d'un évènement
     * @param event Évènement à ajouter
     * @param year  Année de l'évènement
     * @param month Mois de l'évènement
     * @param day   Jour de l'évènement
     */
    public void AddEvent(CalendarEvent event, int year, int month, int day) {
        // On parcours les années (on en a 3) pour trouver l'année correspondante
        for (CalendarYear y: years) {
            if (y.yearNumber == year) {
                // On ajout l'évènement à la date précisée
                y.calendarMonths[month - 1].calendarDays.get(day - 1).events.add(event);
            }
        }
    }
}
