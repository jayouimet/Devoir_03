package com.example.devoir3.obj.calendar;

import android.os.Parcel;
import android.os.Parcelable;

public class CalendarEvent implements Parcelable {
    public String title;
    public String description;

    public String calendarLabel;

    /**
     * Constructeur paramétré
     * @param t     Titre de l'évènement
     * @param desc  Description de l'évènement
     * @param label Libellé de l'évènement dans le calendrier
     */
    public CalendarEvent(String t, String desc, String label) {
        title = t;
        description = desc;
        calendarLabel = label;
    }

    /**
     * Construction de l'évènement par un parcel
     * @param in Parcel contenant les 3 strings représentant le titre, la description et le libellé dans cet ordre
     */
    public CalendarEvent (Parcel in) {
        String[] data = new String[3];

        in.readStringArray(data);
        title = data[0];
        description = data[1];
        calendarLabel = data[2];
    }

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Écriture de l'évènement dans le parcel
     * @param parcel Parcel dans le quel écrire
     * @param i
     */
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringArray(new String[] {title, description, calendarLabel});
    }

    public static final  Parcelable.Creator<CalendarEvent> CREATOR = new Parcelable.Creator<CalendarEvent>() {
        /**
         * Création de l'objer par le parcel passé en paramètre
         * @param parcel Parcel ou les informations sont stockées
         * @return Objet retourné
         */
        @Override
        public CalendarEvent createFromParcel(Parcel parcel) {
            return new CalendarEvent(parcel);
        }

        @Override
        public CalendarEvent[] newArray(int i) {
            return new CalendarEvent[i];
        }
    };
}
