package com.example.devoir3.obj.calendar;

import android.os.Parcel;
import android.os.Parcelable;

public class CalendarEvent implements Parcelable {
    public String title;
    public String description;

    public String calendarLabel;

    public CalendarEvent(String t, String desc, String label) {
        title = t;
        description = desc;
        calendarLabel = label;
    }

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

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringArray(new String[] {title, description, calendarLabel});
    }

    public static final  Parcelable.Creator<CalendarEvent> CREATOR = new Parcelable.Creator<CalendarEvent>() {
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
