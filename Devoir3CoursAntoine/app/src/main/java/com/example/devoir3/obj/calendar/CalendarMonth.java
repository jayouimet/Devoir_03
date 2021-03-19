package com.example.devoir3.obj.calendar;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CalendarMonth {
    public List<CalendarDay> calendarDays;
    public int startingDay;
    public int month;

    /**
     * Création d'un mois paramétré
     * @param m Numéro de mois
     * @param y Année du mois
     */
    public CalendarMonth(int m, int y) {
        // On prend la date associée à cette année
        LocalDateTime date = LocalDateTime.of(y, m, 1, 0, 0);
        month = m;
        // On prend la journée de la semaine où le mois commence
        startingDay = date.getDayOfWeek().getValue();
        // On prend le nombre de jours maximum dans le mois
        int maxDaysInMonth = date.toLocalDate().lengthOfMonth();
        calendarDays = new ArrayList<>();
        // On ajoute les jours au mois
        for (int i = 0; i < maxDaysInMonth; i++) {
            calendarDays.add(new CalendarDay(i + 1));
        }
    }
}
