public class Clock {
    private int h, m, s;

    public Clock(int hours, int minutes,int seconds){
        this.h = hours;
        this.m = minutes;
        this.s = seconds;
    }// Constructor

    public int getHour(){
        return this.h;
    }

    public int getMinutes(){
        return this.m;
    }
    public int getSeconds(){
        return this.s;
    }

    // Get methods

    public void setHour(int hour){
        this.h = hour;
    }

    public void setMinutes(int minutes){
        this.m = minutes;
    }
    public void setSeconds(int seconds){
        this.s = seconds;
    }

    // Set methods

    @Override
    public String toString(){
        return this.h + ":" + this.m + ":" + this.s;
    }

}