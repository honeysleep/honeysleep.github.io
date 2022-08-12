package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    CalendarView calendarView;
    TextView today;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        today = findViewById(R.id.textView2);
        calendarView = findViewById(R.id.calendarView2);

        //날짜변환
        DateFormat formatter = new SimpleDateFormat("yyyy년 MM월 dd일");
        Date date = new Date(calendarView.getDate());
        today.setText(formatter.format(date));

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String day;
                day = year + "년" + (month+1) + "월" + dayOfMonth + "일";
                today.setText(day);
            }
        });
    }
}
