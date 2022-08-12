package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private BarChart barChart;
    private Chart<ChartData<? extends IDataSet<? extends Entry>>> chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<BarEntry> entry_chart = new ArrayList<>(); // 데이터를 담을 Arraylist

        barChart = (BarChart) findViewById(R.id.chart);

        BarData barData = new BarData(); // 차트에 담길 데이터

        entry_chart.add(new BarEntry(1, 10)); //entry_chart1에 좌표 데이터를 담는다.
        entry_chart.add(new BarEntry(2, 20));
        entry_chart.add(new BarEntry(3, 25));
        entry_chart.add(new BarEntry(4, 15));
        entry_chart.add(new BarEntry(5, 40));
        entry_chart.add(new BarEntry(6, 80));
        entry_chart.add(new BarEntry(7, 100));

        BarDataSet barDataSet = new BarDataSet(entry_chart, "효율 (%)"); // 데이터가 담긴 Arraylist 를 BarDataSet 으로 변환한다.
        barDataSet.setValueTextColor(Color.BLACK);

        barDataSet.setColor(Color.rgb( 95, 158, 160)); // 해당 BarDataSet 색 설정 :: 각 막대 과 관련된 세팅은 여기서 설정한다.

        barData.addDataSet(barDataSet); // 해당 BarDataSet 을 적용될 차트에 들어갈 DataSet 에 넣는다.

        barChart.setFitBars(true);
        barChart.setData(barData); // 차트에 위의 DataSet 을 넣는다.

        barChart.invalidate(); // 차트 업데이트
        barChart.getDescription().setText("");
        barChart.setTouchEnabled(false); // 차트 터치 불가능하게

    }
}
