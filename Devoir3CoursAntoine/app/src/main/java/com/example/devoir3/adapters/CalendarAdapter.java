package com.example.devoir3.adapters;

import android.content.Context;
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
        List<TextView> textViews = new ArrayList<>();

        for (int i = 0; i < holder.tableLayout.getChildCount(); i++) {
            View view = holder.tableLayout.getChildAt(i);
            if (view instanceof TableRow) {
                TableRow row = (TableRow) view;
                for (int j = 0; j < row.getChildCount(); j++) {
                    View v = row.getChildAt(j);
                    if (v instanceof TextView) {
                        textViews.add((TextView) v);
                    }
                }
            }
        }

        for (TextView t : textViews) {
            if (textViews.indexOf(t) >= 7)
                t.setText("");
        }

        int count = 0;
        for (int i = 0; i < months.get(position).calendarDays.length; i++) {
            textViews.get(i + ((months.get(position).startingDay) % 7) + 7).setText(String.valueOf(months.get(position).calendarDays[count].dayOfTheMonth));
            count++;
        }
    }

    @Override
    public int getItemCount() {
        return months.size();
    }
}
