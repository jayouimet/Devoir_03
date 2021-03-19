package com.example.devoir3.obj.calendar;

public class CalendarYear {
    public int yearNumber;
    public CalendarMonth[] calendarMonths;

    /**
     * Constructeur paramétré de l'année
     * @param year Année à créer
     */
    public CalendarYear(int year) {
        yearNumber = year;
        calendarMonths = new CalendarMonth[12];
        // Ajout de 12 mois à l'année
        for (int i = 0; i < 12; i++) {
            calendarMonths[i] = new CalendarMonth(i + 1, yearNumber);
        }
    }
}
