package com.example.devoir3;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
public class Notification {
    public List<Notifications> notifications = new ArrayList<Notifications>() {
    };
    public List<Notifications> notificationsUnread = new ArrayList<Notifications>() {
    };
    public Notification() {
        addNotifications();
    }
    //Creation des exemples de notifications possible
    public void addNotifications(){
        String info = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed varius ut est et malesuada." +
                " Morbi euismod fringilla risus, vel interdum dolor suscipit mattis. Pellentesque posuere, est in accumsan feugiat," +
                " quam neque pellentesque erat, non luctus nisi tellus et leo. Phasellus vel augue tellus. Suspendisse orci diam, " +
                "porttitor sed pellentesque ut, mollis in dui. Maecenas ornare risus vitae augue sodales, a scelerisque elit tincidunt.";
        Notifications tempNotif = new Notifications("Note - Travail de mi-session", info,"IFT1215");
        this.notifications.add(tempNotif);
        tempNotif = new Notifications("Demande de 1 étudiant", info,"PHY1220", true);
        this.notifications.add(tempNotif);
        tempNotif = new Notifications("Note - quiz 2", info,"IFT3010");
        this.notifications.add(tempNotif);
        this.notificationsUnread.add(tempNotif);
        tempNotif = new Notifications("Note - quiz 2", info,"IFT3010");
        this.notifications.add(tempNotif);
        this.notificationsUnread.add(tempNotif);
        tempNotif = new Notifications("Note - quiz 2", info,"IFT3010");
        this.notifications.add(tempNotif);
        this.notificationsUnread.add(tempNotif);
        tempNotif = new Notifications("Note - quiz 2", info,"IFT3010");
        this.notifications.add(tempNotif);
        this.notificationsUnread.add(tempNotif);
        tempNotif = new Notifications("Plan de cours", info,"IFT2910",true);
        this.notifications.add(tempNotif);
        tempNotif = new Notifications("Bienvenue à IFT2910", info,"IFT2910");
        this.notifications.add(tempNotif);
        this.notificationsUnread.add(tempNotif);
        tempNotif = new Notifications("Bienvenue à MAT1700", info,"MAT1700",true);
        this.notifications.add(tempNotif);
    }
    public List getNotifications(){
        return this.notifications;
    }
}