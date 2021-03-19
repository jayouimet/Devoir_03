package com.example.devoir3.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.devoir3.EventActivity;
import com.example.devoir3.R;
import com.example.devoir3.obj.calendar.Calendar;
import com.example.devoir3.obj.calendar.CalendarDay;
import com.example.devoir3.obj.calendar.CalendarEvent;
import com.example.devoir3.obj.calendar.CalendarMonth;
import com.example.devoir3.obj.calendar.CalendarYear;

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

        // On initialise notre liste de mois à partir du calendrier
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
        // 2 listes de textview contiendront les numéros de jours et les évènements respectivement
        List<TextView> daysTextViews = new ArrayList<>();
        List<TextView> eventTextViews = new ArrayList<>();

        // Pour chacune des rangées du table view...
        for (int i = 1; i < holder.tableLayout.getChildCount(); i++) {
            View view = holder.tableLayout.getChildAt(i);
            // Si la rangée est pair... (les descriptions d'évènement sont dans les lignes pairs)
            if (i % 2 == 0) {
                // Si c'est bien une rangée...
                if (view instanceof TableRow) {
                    // Pour chaque élément de la colonne...
                    TableRow row = (TableRow) view;
                    for (int j = 0; j < row.getChildCount(); j++) {
                        // Si c'est un textview...
                        View v = row.getChildAt(j);
                        if (v instanceof TextView) {
                            // On ajout le textview à la liste contenant les textviews d'évènements
                            eventTextViews.add((TextView) v);
                        }
                    }
                }
            } else {
                // Si impair...
                // Si c'est bien une rangée...
                if (view instanceof TableRow) {
                    // Pour chaque élément de la colonne...
                    TableRow row = (TableRow) view;
                    for (int j = 0; j < row.getChildCount(); j++) {
                        // Si c'est un textview...
                        View v = row.getChildAt(j);
                        if (v instanceof TextView) {
                            // On ajout le textview à la liste contenant les textviews de numéros de jour
                            daysTextViews.add((TextView) v);
                        }
                    }
                }
            }
        }

        // Chaque textview est réinitialisé
        for (TextView t : daysTextViews) {
            t.setText("");
            t.setBackgroundColor(Color.parseColor("#00000000"));
        }
        // Idem
        for (TextView t : eventTextViews) {
            t.setText("");
            t.setBackgroundColor(Color.parseColor("#00000000"));
            t.setOnClickListener(null);
        }

        // On prend le mois souhaité
        CalendarMonth month = months.get(position);
        // Pour chaque jour su mois...
        for (CalendarDay day: month.calendarDays) {
            // On prend l'index du textview dans sa liste
            int indexOfTextView = month.calendarDays.indexOf(day) + (month.startingDay % 7);
            // On affiche le numéro du jour
            daysTextViews.get(indexOfTextView).setText(String.valueOf(day.dayOfTheMonth));
            // S'il y a au moins un event
            if (day.events.size() > 0) {
                // On met le background à rouge pale
                daysTextViews.get(indexOfTextView).setBackgroundColor(context.getColor(R.color.light_red));
                eventTextViews.get(indexOfTextView).setBackgroundColor(context.getColor(R.color.light_red));
                // Concaténation des libéllés d'évènement
                StringBuilder stringBuilder = new StringBuilder();
                for (CalendarEvent event : day.events) {
                    stringBuilder.append(event.calendarLabel);
                    if (day.events.indexOf(event) < day.events.size() - 1)
                        stringBuilder.append("\n");
                }
                // Affichage du texte
                eventTextViews.get(indexOfTextView).setText(stringBuilder.toString());
                // Liaison de l'activité correspondante
                eventTextViews.get(indexOfTextView).setOnClickListener(e->{
                    Intent intent = new Intent(context, EventActivity.class);
                    intent.putExtra("calendarEvent", day.events.get(0));
                    context.startActivity(intent);
                });
            }
        }
    }

    @Override
    public int getItemCount() {
        return months.size();
    }
}
