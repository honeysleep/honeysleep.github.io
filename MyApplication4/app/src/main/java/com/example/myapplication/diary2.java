package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

public class diary2 extends AppCompatActivity {

    int preHour;
    int preMin;
    String sleepLatencyText;
    String awakeTimeAfterSleepText;

    int aftHour;
    int aftMin;


    //TextView tv_1;
    //TextView tv_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary2);

        //tv_1 = findViewById(R.id.textView3);
        //tv_2 = findViewById(R.id.textView4);

        Button continue2 = (Button)findViewById(R.id.continue2);
        Spinner spin2 = (Spinner) findViewById(R.id.spinner2_1);
        TimePicker timePicker2 = findViewById(R.id.timePicker2_1);


        final String[] awakeTimeAfterSleep = {"0", "10", "20", "30", "40", "50", "60", "90", "120", "150", "180"};



        Intent intent = getIntent();
        preHour = intent.getIntExtra("preHour",1);
        preMin = intent.getIntExtra("preMin",1);
        sleepLatencyText = intent.getStringExtra("sleepLatencyText");

        //tv_1.setText("슬립레이턴시 : " + sleepLatencyText);
        //tv_2.setText(preHour + "시 " + preMin + "분");

        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), R.layout.spiner_item, awakeTimeAfterSleep);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin2.setAdapter(adapter);

        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                StringBuilder sb = new StringBuilder();
                sb.append(spin2.getItemAtPosition(i));
                awakeTimeAfterSleepText = sb.toString();
                //Toast.makeText(getApplicationContext(),"선택된 아이템 : "+textInt, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        timePicker2.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                aftHour = hourOfDay;
                aftMin = minute;
                //Toast.makeText(getApplicationContext(),preHour[0]+ " 시 "+ preMin[0] + "분" ,Toast.LENGTH_SHORT).show();
            }
        });

        //다음화면으로 보내기기
       continue2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent exIntent = new Intent(getApplicationContext(), sleepDairyResult.class);
                exIntent.putExtra("preHour",preHour);
                exIntent.putExtra("preMin",preMin);
                exIntent.putExtra("sleepLatencyText",sleepLatencyText);

                exIntent.putExtra("aftHour",aftHour);
                exIntent.putExtra("aftMin",aftMin);
                exIntent.putExtra("awakeTimeAfterSleepText",awakeTimeAfterSleepText);

                startActivity(exIntent);
            }
        });

    }
}