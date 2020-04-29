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

    /**
     *
     * @param hours hours (int)
     * @param minutes minutes (int)
     * @param seconds seconds (int)
     * @throws IllegalClockException
     */
    public Clock(int hours, int minutes,int seconds) throws IllegalClockException{
        if(isValidClock(hours, minutes, seconds)){
            this.setHours(hours);
            this.setMinutes(minutes);
            this.setSeconds(seconds);
        }else{
            throw new IllegalClockException(hours+":"+minutes+":"+seconds);
        }


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
    public void setHours(int hour){
        this.h = hour;
    }
    public void setMinutes(int minutes){
        this.m = minutes;
    }
    public void setSeconds(int seconds){
        this.s = seconds;
    }

    /**
     * Checks validity of the clocks
     * @param hours hours (int)
     * @param minutes minutes (int)
     * @param seconds seconds (int)
     * @return  returns true if clock is valid, false otherwise
     */
    public boolean isValidClock(int hours, int minutes, int seconds)  {
        if(hours > 23 || minutes > 59 || seconds > 59){
            return false;
        }else return true;
    }
    // toString method returns the
    // data in the original format "hh:mm:ss"
    @Override
    public String toString(){
        return this.h + ":" + this.m + ":" + this.s;
    }

    /**
     * Compares this and the other clock object
     *
     * @param o Other Clock
     * @return comparison result (int type)
     */
    public int compareTo(Clock o){
        // compare hours
        if(this.getHour() >= o.getHour()){

            // if hours are equal compare minutes
            if(this.getHour() == o.getHour()) {
                // compare minutes
                if (this.getMinutes() >= o.getMinutes()) {

                    // if minutes are equal compare seconds
                    if (this.getMinutes() == o.getMinutes()) {

                        // compare seconds
                        if (this.getSeconds() >= o.getSeconds()){
                            return 1;
                        }
                        // this.getSeconds() < o.getSeconds()
                        else{
                            return -1;

                        }
                    }
                    return 1;
                }
                // this.getMinutes < o.getMinutes
                else {
                    return -1;

                }
            }
            // this.getHour() < o.getHour()
            else{
                return 1;
            }
        }else {
            return -1;
        }

    } // compareTo

}
