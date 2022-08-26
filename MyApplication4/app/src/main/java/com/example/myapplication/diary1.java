package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.Collections;

public class diary1 extends AppCompatActivity {

    int preHour=-1;
    int preMin=0;
    String sleepLatencyText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary1);

        final String[] sleepLatency = {"0", "10", "20", "30", "40", "50", "60", "90", "120", "150", "180"};



        Spinner spin = (Spinner) findViewById(R.id.spinner1_1);
        //TextView tv_result;

        Button buttonBack = findViewById(R.id.buttonBack);
        //EditText edt_result = findViewById(R.id.edt_result);
        TimePicker timePicker = findViewById(R.id.timePicker1_1);

        //Calendar calendar = Calendar.getInstance();



        Button continue1 = (Button)findViewById(R.id.continue1);


        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), R.layout.spiner_item, sleepLatency);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                preHour = hourOfDay;
                preMin = minute;
                //Toast.makeText(getApplicationContext(),preHour[0]+ " 시 "+ preMin[0] + "분" ,Toast.LENGTH_SHORT).show();
            }
        });

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                StringBuilder sb = new StringBuilder();
                sb.append(spin.getItemAtPosition(i));
                sleepLatencyText = sb.toString();
                //Toast.makeText(getApplicationContext(),"선택된 아이템 : "+textInt, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //다음화면으로 전환
        continue1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), diary2.class);
                intent.putExtra("preHour",preHour);
                intent.putExtra("preMin",preMin);
                intent.putExtra("sleepLatencyText",sleepLatencyText);
                startActivity(intent);
            }
        });



    }
}