package com.example.myapplication;

public class SleepData implements Comparable<SleepData>{



    int month;
    int day;
    int absDay;

    int preH;
    int preM;
    int aftH;
    int aftM;


    int tib;
    int sl;
    float se;
    int tst;



    int totalAwakeTime;

    @Override
    public int compareTo(SleepData sleepdata){
        if(sleepdata.absDay < absDay)
            return 1;
        else if (sleepdata.absDay > absDay)
            return -1;
        return 0 ;
    }

    public SleepData(int month, int day, int preH, int preM, int aftH, int aftM, int sl, int totalAwakeTime){
        this.month = month;
        this.day = day;

        if(month == 1)
            absDay = day;
        else if(month ==2)
            absDay = 31+day;
        else if(month ==3)
            absDay = 31+28+day;
        else if(month ==4)
            absDay = 31+28+31+day;
        else if(month ==5)
            absDay = 31+28+31+30+day;
        else if(month ==6)
            absDay = 31+28+31+30+31+day;
        else if(month ==7)
            absDay = 31+28+31+30+31+30+day;
        else if(month ==8)
            absDay = 31+28+31+30+31+30+31+day;
        else if(month ==9)
            absDay = 31+28+31+30+31+30+31+31+day;
        else if(month ==10)
            absDay = 31+28+31+30+31+30+31+31+30+day;
        else if(month ==11)
            absDay = 31+28+31+30+31+30+31+31+30+31+day;
        else if(month ==12)
            absDay = 31+28+31+30+31+30+31+31+30+31+30+day;

        this.preH=preH;
        this.preM=preM;
        this.aftH=aftH;
        this.aftM=aftM;
        this.sl=sl;
        this.totalAwakeTime=totalAwakeTime;

        if(preH > aftH)
            aftH+=24;

        this.tib=aftH*60+aftM - (preH*60 + preM);
        this.tst = this.tib - this.sl - this.totalAwakeTime;
        this.se = (this.tst/(float)this.tib)*100;
    }

    public int getTotalAwakeTime() {
        return totalAwakeTime;
    }

    public int getTst() {
        return tst;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getAbsDay() {
        return absDay;
    }

    public int getPreH() {
        return preH;
    }

    public int getPreM() {
        return preM;
    }

    public int getAftH() {
        return aftH;
    }

    public int getAftM() {
        return aftM;
    }

    public int getTib() {
        return tib;
    }

    public int getSl() {
        return sl;
    }

    public float getSe() {
        return se;
    }

}
