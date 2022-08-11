package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class sleepDairyResult extends AppCompatActivity {

    int preHour;
    int preMin;
    String sleepLatencyText;
    String awakeTimeAfterSleepText;

    int aftHour;
    int aftMin;

    int timeInBed=0;
    int totalSleepTime=0;

    String sleepEfficiency;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep_dairy_result);


        TextView tv_3 = findViewById(R.id.textView3);
        TextView tv_4 = findViewById(R.id.textView4);
        TextView tv_5 = findViewById(R.id.textView5);
        TextView tv_6 = findViewById(R.id.textView6);


        TextView se = findViewById(R.id.textView2);

        ProgressBar progressBar = findViewById(R.id.progressBar2);

        Intent intent = getIntent();
        preHour = intent.getIntExtra("preHour",1);
        preMin = intent.getIntExtra("preMin",1);
        sleepLatencyText = intent.getStringExtra("sleepLatencyText");
        awakeTimeAfterSleepText = intent.getStringExtra("awakeTimeAfterSleepText");
        aftHour = intent.getIntExtra("aftHour",1);
        aftMin = intent.getIntExtra("aftMin",1);

        if(preHour > aftHour)
        {
            aftHour += 24;
        }

        timeInBed = (aftHour*60+aftMin) - (preHour*60+preMin);
        totalSleepTime = timeInBed - Integer.parseInt(sleepLatencyText) - Integer.parseInt(awakeTimeAfterSleepText);
        float result =  (totalSleepTime/(float)timeInBed)*100;
        sleepEfficiency = String.format("%.0f", result);

        se.setText(sleepEfficiency + "%");
        progressBar.setProgress(Integer.parseInt(sleepEfficiency));





        tv_3.setText("슬립레이턴시 : " + sleepLatencyText);
        tv_4.setText(preHour + "시 " + preMin + "분");
        tv_5.setText("잠든후 중간에 깬 시간 : " + awakeTimeAfterSleepText);
        tv_6.setText(aftHour + "시 " + aftMin + "분" + "\n tib : " +timeInBed+ "\nTST : "+totalSleepTime +"\n 결과 : "+result + "\nfloat tib:" + (float)timeInBed + "\ntst" + (float)totalSleepTime
                       + "\n" + 373/(float)383);




    }
}