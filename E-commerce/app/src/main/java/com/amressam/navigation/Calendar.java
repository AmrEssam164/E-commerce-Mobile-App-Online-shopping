package com.amressam.navigation;

import android.os.Bundle;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Calendar extends AppCompatActivity {

    CalendarView calendarView;
    public static String date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        calendarView = (CalendarView) findViewById(R.id.calendarView);
        CalendarView.OnDateChangeListener onDateChangeListener = new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                date = month+1 + "/" + dayOfMonth + "/" + year ;
                onBackPressed();
            }
        };
        calendarView.setOnDateChangeListener(onDateChangeListener);
    }
}
