/**
 * @AUthor: Khademul Mahin
 *
 * The Clock class helps to
 * keep a lot of data like
 * hours, minutes, and seconds
 * in one object.
 */

public class Clock {

    // Initialize hours, minutes and seconds as private integers
    private int h, m, s;

    public Clock(int hours, int minutes,int seconds){
        this.h = hours;
        this.m = minutes;
        this.s = seconds;
    }// Constructor

	
	// Get methods
    public int getHour(){
        return this.h;
    }
    public int getMinutes(){
        return this.m;
    }
    public int getSeconds(){
        return this.s;
    }

    
	// Set methods
    public void setHour(int hour){
        this.h = hour;
    }
    public void setMinutes(int minutes){
        this.m = minutes;
    }
    public void setSeconds(int seconds){
        this.s = seconds;
    }

    
	// toString method returns the 
	// data in the original format "hh:mm:ss"
    @Override 
    public String toString(){
        return this.h + ":" + this.m + ":" + this.s;
    }

}
