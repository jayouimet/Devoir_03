package com.example.devoir3.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.devoir3.R;
import com.example.devoir3.obj.calendar.Calendar;
import com.example.devoir3.obj.calendar.CalendarDay;
import com.example.devoir3.obj.calendar.CalendarEvent;
import com.example.devoir3.obj.calendar.CalendarMonth;
import com.example.devoir3.obj.calendar.CalendarYear;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.CalendarViewHolder> {
    private Calendar calendar;
    private Context context;
    private List<CalendarMonth> months;

    public class CalendarViewHolder extends RecyclerView.ViewHolder {
        TableLayout tableLayout;

        public CalendarViewHolder (@NonNull View itemView) {
            super(itemView);
            tableLayout = itemView.findViewById(R.id.calendarTableView);
        }
    }

    public CalendarAdapter(Context ct, Calendar c) {
        calendar = c;
        context = ct;

        months = new ArrayList<>();

        for (CalendarYear y : c.years) {
            for (CalendarMonth m : y.calendarMonths) {
                months.add(m);
            }
        }
    }

    @NonNull
    @Override
    public CalendarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.calendar_grid_layout, parent, false);
        return new CalendarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CalendarViewHolder holder, int position) {
        List<TextView> daysTextViews = new ArrayList<>();
        List<TextView> eventTextViews = new ArrayList<>();

        for (int i = 1; i < holder.tableLayout.getChildCount(); i++) {
            View view = holder.tableLayout.getChildAt(i);
            if (i % 2 == 0) {
                if (view instanceof TableRow) {
                    TableRow row = (TableRow) view;
                    for (int j = 0; j < row.getChildCount(); j++) {
                        View v = row.getChildAt(j);
                        if (v instanceof TextView) {
                            eventTextViews.add((TextView) v);
                        }
                    }
                }
            } else {
                if (view instanceof TableRow) {
                    TableRow row = (TableRow) view;
                    for (int j = 0; j < row.getChildCount(); j++) {
                        View v = row.getChildAt(j);
                        if (v instanceof TextView) {
                            daysTextViews.add((TextView) v);
                        }
                    }
                }
            }
        }

        for (TextView t : daysTextViews) {
            t.setText("");
            t.setBackgroundColor(Color.parseColor("#00000000"));
        }

        for (TextView t : eventTextViews) {
            t.setText("");
            t.setBackgroundColor(Color.parseColor("#00000000"));
        }

        CalendarMonth month = months.get(position);
        for (CalendarDay day: month.calendarDays) {
            int indexOfTextView = month.calendarDays.indexOf(day) + (month.startingDay % 7);
            daysTextViews.get(indexOfTextView).setText(String.valueOf(day.dayOfTheMonth));
            if (day.events.size() > 0) {
                daysTextViews.get(indexOfTextView).setBackgroundColor(context.getColor(R.color.light_red));
                eventTextViews.get(indexOfTextView).setBackgroundColor(context.getColor(R.color.light_red));

                StringBuilder stringBuilder = new StringBuilder();
                for (CalendarEvent event : day.events) {
                    stringBuilder.append(event.description);
                    if (day.events.indexOf(event) < day.events.size() - 1)
                        stringBuilder.append("\n");
                }
                eventTextViews.get(indexOfTextView).setText(stringBuilder.toString());
            }
        }
    }

    @Override
    public int getItemCount() {
        return months.size();
    }
}
