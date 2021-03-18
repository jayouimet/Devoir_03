package com.example.devoir3.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.devoir3.R;
import com.example.devoir3.obj.calendar.Calendar;
import com.example.devoir3.obj.calendar.CalendarMonth;
import com.example.devoir3.obj.calendar.CalendarYear;

public class CalendarMonthNameAdapter extends RecyclerView.Adapter<CalendarMonthNameAdapter.CalendarMonthNameViewHolder> {
    private Calendar calendar;
    private Context context;
    private String[] monthsName;
    private int[] months;

    public class CalendarMonthNameViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public CalendarMonthNameViewHolder (@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.calendarMonthNameLabel);
        }
    }

    public CalendarMonthNameAdapter(Context ct, Calendar c) {
        calendar = c;
        context = ct;
        monthsName = context.getResources().getStringArray(R.array.months_name);

        int num = 0;
        for (CalendarYear y: c.years) {
            for (CalendarMonth m: y.calendarMonths) {
                num++;
            }
        }

        months = new int[num];

        for (int i = 0; i < num; i++) {
            months[i] = i;
        }
    }

    @NonNull
    @Override
    public CalendarMonthNameAdapter.CalendarMonthNameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.calendar_month_name_layout, parent, false);
        return new CalendarMonthNameAdapter.CalendarMonthNameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CalendarMonthNameAdapter.CalendarMonthNameViewHolder holder, int position) {
        holder.textView.setText(monthsName[months[position] % 12]);
    }

    @Override
    public int getItemCount() {
        return months.length;
    }
}
