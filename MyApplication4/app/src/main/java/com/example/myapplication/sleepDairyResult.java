package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;

public class sleepDairyResult extends AppCompatActivity {

    int preHour;
    int preMin;
    String sleepLatencyText;
    String awakeTimeAfterSleepText;

    int aftHour;
    int aftMin;

    int timeInBed=0;
    int totalSleepTime=0;

    String sleepEfficiencyText;
    int sleepEfficiency;

    ArrayList<SleepData> sleepList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep_dairy_result);


        TextView tv_3 = findViewById(R.id.textView3);
        /*
        TextView tv_4 = findViewById(R.id.textView4);
        TextView tv_5 = findViewById(R.id.textView5);
        TextView tv_6 = findViewById(R.id.textView6);
        */



        //TextView se = findViewById(R.id.textView2);

        //ProgressBar progressBar = findViewById(R.id.progressBar2);

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

        //tib
        timeInBed = (aftHour*60+aftMin) - (preHour*60+preMin);

        totalSleepTime = timeInBed - Integer.parseInt(sleepLatencyText) - Integer.parseInt(awakeTimeAfterSleepText);
        float result =  (totalSleepTime/(float)timeInBed)*100;
        sleepEfficiencyText = String.format("%.0f", result);
        sleepEfficiency=Integer.parseInt(sleepEfficiencyText);

        //se.setText(sleepEfficiency + "%");
        //progressBar.setProgress(sleepEfficiency);


        //sleepList.add(new SleepData(8,15,23,6,30,85,24,24));
        /*
        sleepList.add(new SleepData(8,16,22,3,90,85));
        sleepList.add(new SleepData(8,17,21,5,42,85));
        sleepList.add(new SleepData(8,18,22,7,64,85));
        sleepList.add(new SleepData(8,19,23,5,76,85));
        */

        /*
        tv_3.setText("슬립레이턴시 : " + sleepLatencyText);
        tv_4.setText(preHour + "시 " + preMin + "분");
        tv_5.setText("잠든후 중간에 깬 시간 : " + awakeTimeAfterSleepText);
        tv_6.setText(aftHour + "시 " + aftMin + "분" + "\n tib : " +timeInBed+ "\nTST : "+totalSleepTime +"\n 결과 : "+result + "\nfloat tib:" + (float)timeInBed + "\ntst" + (float)totalSleepTime);
        */

        ////////////////////////////////////////////////////////////////////////////////////////////
        //sleepList.add(new SleepData(2,14,preHour, preMin, aftHour, aftMin, Integer.parseInt(sleepLatencyText),Integer.parseInt(awakeTimeAfterSleepText)));

        //불면증환자 3.4~4.4

        sleepList.add(new SleepData(3,4,23,0,8,0,0,120));
        sleepList.add(new SleepData(3,5,23,0,6,50,150,0));
        sleepList.add(new SleepData(3,6,23,0,5,50,270,0));
        sleepList.add(new SleepData(3,7,23,0,6,0,60,110));
        sleepList.add(new SleepData(3,8,23,0,6,0,200,20));
        sleepList.add(new SleepData(3,9,23,0,6,0,30,80));
        sleepList.add(new SleepData(3,10,23,0,6,0,30,50));
        sleepList.add(new SleepData(3,11,23,0,10,0,30,270));
        sleepList.add(new SleepData(3,12,23,0,6,0,0,40));
        sleepList.add(new SleepData(3,13,23,0,6,0,80,80));
        sleepList.add(new SleepData(3,14,23,0,6,0,150,30));
        sleepList.add(new SleepData(3,15,23,0,6,0,100,100));
        sleepList.add(new SleepData(3,16,23,0,6,0,20,30));
        sleepList.add(new SleepData(3,17,23,0,8,0,0,90));
        sleepList.add(new SleepData(3,18,23,0,6,0,0,60));
        sleepList.add(new SleepData(3,19,23,0,5,30,80,90));
        sleepList.add(new SleepData(3,20,23,0,5,30,0,390));
        sleepList.add(new SleepData(3,21,23,0,6,0,30,30));
        sleepList.add(new SleepData(3,22,23,0,6,0,60,170));
        sleepList.add(new SleepData(3,23,23,0,6,0,300,0));
        sleepList.add(new SleepData(3,24,23,0,6,0,0,420));
        sleepList.add(new SleepData(3,25,23,0,9,30,0,20));
        sleepList.add(new SleepData(3,26,23,0,9,45,240,10));
        sleepList.add(new SleepData(3,27,23,0,9,0,210,30));
        sleepList.add(new SleepData(3,28,23,0,9,0,0,50));
        sleepList.add(new SleepData(3,29,23,0,7,10,0,40));
        sleepList.add(new SleepData(3,30,23,0,7,10,300,10));
        sleepList.add(new SleepData(3,31,23,0,8,0,90,30));
        sleepList.add(new SleepData(4,1,23,0,6,10,90,30));
        sleepList.add(new SleepData(4,2,23,0,9,0,120,80));
        sleepList.add(new SleepData(4,3,23,0,9,0,60,30));
        sleepList.add(new SleepData(4,4,23,0,8,30,60,90));


        //불면증환자 3.31~4.5
        /*
        sleepList.add(new SleepData(3,31,23,0,7,0,90,60));
        sleepList.add(new SleepData(4,1,22,30,6,0,30,120));
        sleepList.add(new SleepData(4,2,22,30,6,40,60,220));
        sleepList.add(new SleepData(4,3,22,30,7,30,60,120));
        sleepList.add(new SleepData(4,4,22,30,7,0,40,60));
        sleepList.add(new SleepData(4,5,0,0,7,20,40,80));
        */

        //sleepList.add(new SleepData(8,19,22,0,8,0,45,60));
        //sleepList.add(new SleepData(8,19,22,0,8,0,45,60));
        //sleepList.add(new SleepData(8,19,22,0,8,0,45,60));
        //sleepList.add(new SleepData(8,19,22,0,8,0,45,60));

        Collections.sort(sleepList);
        ////////////////////////////////////////////////////////////////////////////////////////////

        for(int i=0; i<sleepList.size(); i++) {
            tv_3.append(sleepList.get(i).getMonth() + "월 " + sleepList.get(i).getDay() + "일 ");
            tv_3.append("SL : " + sleepList.get(i).getSl() + ' ');
            tv_3.append("SE : " + sleepList.get(i).getSe() + "%\n");
            tv_3.append("TST(분): " + sleepList.get(i).getTst() + " " +
                    "TST(시간) : " + sleepList.get(i).getTst() / 60 + " " +
                    "TIB : " + sleepList.get(i).getPreH() + "시 " + sleepList.get(i).getPreM() + "분\n" +
                    "일어난 시간 : " + (sleepList.get(i).getAftH() >= 24 ? sleepList.get(i).getAftH() - 24 : sleepList.get(i).getAftH()) + "시" + sleepList.get(i).getAftM() + "분\n");

            //SL이 30보다 작은 경우
            if(sleepList.get(i).getSl()<30){

                //SE가 85보다 큰경우
                if(sleepList.get(i).getSe()>=85){

                    if(sleepList.get(i).getTst()/60 >=7){

                    }
                    else{

                    }
                }
                //SE85보다 작은경우
                else{
                    if(sleepList.get(i).getTst()/60 >=7){
                        tv_3.append("Sleep maintenance I");
                    }
                    else{
                        tv_3.append("Sleep maintenance I;\n수면부족");
                    }
                }
            }
            //SL이 30보다 큰경우
            else{
                //SE가 85보다 큰경우
                if(sleepList.get(i).getSe()>=85){
                    //TST가 7시간보다 큰경우
                    if(sleepList.get(i).getTst()/60 >= 7){
                        tv_3.append("Sleep onset I +\n" +
                                "Delayed sleep phase\nsyndrome");
                    }
                    //TST가 7시간보다 낮은 경우
                    else{
                        tv_3.append("Sleep onset Insomenia + SD");
                    }
                }
                //SE가 85보다 낮은 경우
                else{
                    //TST가 7시간보다 큰 경우
                    if(sleepList.get(i).getTst()/60 >= 7){
                        tv_3.append("Sleep onset Insomenia + \n " +
                                "Sleep maintenance Insomenia" );
                    }
                    //TST가 7시간보다 낮은 경우
                    else{
                        tv_3.append("Sleep maintenance Insomenia + \n 수면부족");
                    }
                }
            }
            tv_3.append("\n\n");
        }

        Collections.sort(sleepList,Collections.reverseOrder());

        /////////////////////////////////////////////////////////
        int avg=sleepList.size();
        ///////////////////////////////////////////////////////////

        totalSleepTime=0;
        preHour=0;
        preMin=0;
        int sl=0;


        aftHour=0;
        aftMin=0;
        int preT=0;
        int aftT=0;

        float se=0;

        timeInBed=0;
        totalSleepTime=0;
        int awakeAftSleep=0;


        sleepEfficiency=0;
        for(int i=0; i<avg; i++) {
            totalSleepTime+=sleepList.get(i).getTst(); //tst
            sl+=sleepList.get(i).getSl();
            se+=sleepList.get(i).getSe();
            timeInBed += sleepList.get(i).getTib();
            awakeAftSleep +=sleepList.get(i).getTotalAwakeTime();
            aftT += sleepList.get(i).getAftH()*60 + sleepList.get(i).getAftM();
            //tv_3.append("\n"+aftT+"\n");
            preHour+=sleepList.get(i).getPreH();
            //if(sleepList.get(i).getPreH())
            //sleepList.get(i).getTib()

            if(sleepList.get(i).getPreH() <= sleepList.get(i).getAftH() && sleepList.get(i).getPreH()>=0 && sleepList.get(i).getPreH()<=11){
                preT+=60*24;
            }
            preT += sleepList.get(i).getPreH()*60 + sleepList.get(i).getPreM();

        }

        float dsh=0;
        dsh=preT/(float)(avg*60);
        float dec=0;
        dec=dsh-(int)dsh;

        /*
        tv_3.append("\n" + dec+ "\n");
        tv_3.append("\n" + dec*60+ "\n");
        tv_3.append("\n" + (int)(dec*60)+ "\n");
        */


        float aDsh=0;
        aDsh = aftT/(float)(avg*60);
        float aDec=0;
        aDec=aDsh-(int)aDsh;

        //시간평균 재계산하기
        tv_3.append("\n평균 tst(시간): " + (totalSleepTime/avg)/60 +'\n'
                    +"평균 sl(분): " + sl/avg + '\n'
                    +"잠에 든 시간 평균: " + (dsh >=24 ? (int)dsh-24 : (int)dsh) +"시 " + (int)(dec*60) + "분\n"
                    +"일어난 시간 평균: " + (int)aDsh + "시 " + (int)(aDec*60) + "분\n"
                    +"평균 수면효율: " + se/avg + "%\n"
                    +"수면 후 깨어있던 시간 평균: " + awakeAftSleep/avg+"분\n");


        /*
        tv_3.append(' ' + "월 "+ ' ' +"일");
        tv_3.append("슬립레이턴시 : " + sleepLatencyText+' ');
        tv_3.append("SE : "+sleepEfficiency+"%\n");
        tv_3.append("TST(분): " + totalSleepTime + " " +
                "TST(시간) : " + totalSleepTime/60 + " " +
                "TIB : " + preHour + "시 "+ preMin+"분\n" +
                "일어난 시간 : " + (aftHour >= 24 ? aftHour-24 : aftHour)+"시"+aftMin+"분\n");
        */

        /*
        //SL이 30보다 작은 경우
        if(sleepList.get(i).getSl()<30){

            //SE가 85보다 큰경우
            if(sleepList.get(i).getSe()>=85){

                if(sleepList.get(i).getTst()/60 >=7){

                }
                else{

                }
            }
            //SE85보다 작은경우
            else{
                if(sleepList.get(i).getTst()/60 >=7){
                    tv_3.append("Sleep maintenance I\n");
                }
                else{
                    tv_3.append("Sleep maintenance I;\n수면부족");
                }
            }
        }
        //SL이 30보다 큰경우
        else{
            //SE가 85보다 큰경우
            if(sleepList.get(i).getSe()>=85){
                //TST가 7시간보다 큰경우
                if(sleepList.get(i).getTst()/60 >= 7){
                    tv_3.append("Sleep onset I +\n" +
                            "Delayed sleep phase\nsyndrome");
                }
                //TST가 7시간보다 낮은 경우
                else{
                    tv_3.append("Sleep onset Insomenia + SD");
                }
            }
            //SE가 85보다 낮은 경우
            else{
                //TST가 7시간보다 큰 경우
                if(sleepList.get(i).getTst()/60 >= 7){
                    tv_3.append("Sleep onset Insomenia + \n " +
                            "Sleep maintenance Insomenia" );
                }
                //TST가 7시간보다 낮은 경우
                else{
                    tv_3.append("Sleep maintenance Insomenia + \n 수면부족");
                }
            }
        }
       */


    }
}