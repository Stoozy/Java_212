/**
 * @author Khademul Mahin
 *
 * UnsortedClockList extends ClockList and
 * has an add method which simply uses the append method from the
 * super class.
 */

public class UnsortedClockList extends ClockList {
    public UnsortedClockList(){
    } // empty constructor

    public void add(Clock c){
        append(c);
    }// add

}
