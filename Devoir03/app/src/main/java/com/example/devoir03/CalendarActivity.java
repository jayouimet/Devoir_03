package com.example.devoir03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.devoir03.adapters.CalendarAdapter;
import com.example.devoir03.adapters.CalendarMonthNameAdapter;
import com.example.devoir03.obj.calendar.Calendar;

import java.time.LocalDateTime;

public class CalendarActivity extends AppCompatActivity {
    private LinearLayoutManager calendarLinearLayoutManager;
    private LinearLayoutManager calendarMonthNameLinearLayoutManager;
    private RecyclerView calendarRecyclerView;
    private RecyclerView calendarMonthNameRecyclerView;
    private ImageButton previousMonthButton;
    private ImageButton nextMonthButton;

    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        previousMonthButton = findViewById(R.id.previousMonthButton);
        nextMonthButton = findViewById(R.id.nextMonthButton);

        calendar = new Calendar();

        calendarMonthNameRecyclerView = findViewById(R.id.calendarMonthNameRecyclerView);
        initialiseCalendarMonthNameRecyclerView();

        calendarRecyclerView = findViewById(R.id.calendarRecyclerView);
        initialiseCalendarRecyclerView();

        calendarRecyclerView.scrollToPosition(LocalDateTime.now().getMonth().getValue() - 1);
        calendarMonthNameRecyclerView.scrollToPosition(LocalDateTime.now().getMonth().getValue() - 1);

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