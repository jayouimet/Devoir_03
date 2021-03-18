package com.example.devoir3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.example.devoir3.adapters.CalendarAdapter;
import com.example.devoir3.adapters.CalendarMonthNameAdapter;
import com.example.devoir3.obj.calendar.Calendar;
import com.example.devoir3.obj.calendar.CalendarEvent;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.time.LocalDateTime;

public class CalendarActivity extends AppCompatActivity {
    private LinearLayoutManager calendarLinearLayoutManager;
    private LinearLayoutManager calendarMonthNameLinearLayoutManager;
    private RecyclerView calendarRecyclerView;
    private RecyclerView calendarMonthNameRecyclerView;
    private ImageButton previousMonthButton;
    private ImageButton nextMonthButton;
    private BottomNavigationView bottomNavBar;

    private ImageButton profileButton;
    private ImageButton notificationButton;

    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        previousMonthButton = findViewById(R.id.previousMonthButton);
        nextMonthButton = findViewById(R.id.nextMonthButton);
        profileButton = findViewById(R.id.calendarProfileButton);
        notificationButton = findViewById(R.id.calendarNotificationButton);

        calendar = new Calendar();
        calendar.AddEvent(new CalendarEvent("Devoir 3",
                "TP3 Interface personne machine\n\n" +
                        "Combiner design et implémentation\n\n" +
                        "Date de remise : jeudi 18 mars 2021, 23:59"
                , "Remise du devoir 3"), 2021, 3, 18);

        calendarMonthNameRecyclerView = findViewById(R.id.calendarMonthNameRecyclerView);
        initialiseCalendarMonthNameRecyclerView();

        calendarRecyclerView = findViewById(R.id.calendarRecyclerView);
        initialiseCalendarRecyclerView();

        calendarRecyclerView.scrollToPosition(LocalDateTime.now().getMonth().getValue() - 1 + 12);
        calendarMonthNameRecyclerView.scrollToPosition(LocalDateTime.now().getMonth().getValue() - 1 + 12);

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CalendarActivity.this, MonProfil.class);
                startActivity(intent);
            }
        });

        notificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CalendarActivity.this, NotificationPage.class);
                startActivity(intent);
            }
        });

        previousMonthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendarRecyclerView.scrollToPosition(((LinearLayoutManager)(calendarRecyclerView.getLayoutManager())).findFirstVisibleItemPosition() - 1);
                calendarMonthNameRecyclerView.scrollToPosition(((LinearLayoutManager)(calendarMonthNameRecyclerView.getLayoutManager())).findFirstVisibleItemPosition() - 1);
            }
        });

        nextMonthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendarRecyclerView.scrollToPosition(((LinearLayoutManager)(calendarRecyclerView.getLayoutManager())).findFirstVisibleItemPosition() + 1);
                calendarMonthNameRecyclerView.scrollToPosition(((LinearLayoutManager)(calendarMonthNameRecyclerView.getLayoutManager())).findFirstVisibleItemPosition() + 1);
            }
        });

        bottomNavBar = findViewById(R.id.bottomNavBar);
        bottomNavBar.setSelectedItemId(R.id.calendrier);
        bottomNavBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.mescours){
                    Intent intent=new Intent(CalendarActivity.this, MesCours.class);
                    startActivity(intent);
                    return true;
                }
                else if(item.getItemId()==R.id.search){
                    Intent intent=new Intent(CalendarActivity.this,RechercherCours.class);
                    startActivity(intent);
                    return true;
                }
                else if(item.getItemId()==R.id.calendrier){

                    return true;
                }
                else if(item.getItemId()==R.id.message){
                    Intent intent = new Intent(CalendarActivity.this,Messagerie.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }

        });
    }

    private void initialiseCalendarMonthNameRecyclerView() {
        CalendarMonthNameAdapter calendarMonthNameAdapter = new CalendarMonthNameAdapter(this, calendar);
        calendarMonthNameRecyclerView.setAdapter(calendarMonthNameAdapter);
        calendarMonthNameLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false) {
            @Override
            public boolean canScrollHorizontally() {
                return false;
            }
        };
        calendarMonthNameRecyclerView.setLayoutManager(calendarMonthNameLinearLayoutManager);
    }

    private void initialiseCalendarRecyclerView() {
        CalendarAdapter calendarAdapter = new CalendarAdapter(this, calendar);
        calendarRecyclerView.setAdapter(calendarAdapter);
        calendarLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false) {
            @Override
            public boolean canScrollHorizontally() {
                return false;
            }
        };
        calendarRecyclerView.setLayoutManager(calendarLinearLayoutManager);
    }
}