/**
 * @author Khademul Mahin
 *
 * Abstract linked list class ClockList contains a constructor
 * and an append method which just makes the last node refernce
 * the new node (n) and moves the pointer (last) to the new Node (n);
 *
 *
 */

public abstract class ClockList {
    protected ClockNode head ;
    protected ClockNode first;
    protected ClockNode last;
    protected int length = 0;

    public ClockList(){
        head = new ClockNode(new Clock(0,0,0)); //dummy head node;
        first = head;
        last = head;
    } // simple constructor which makes first and last point to a dummy head node;

    public void append(Clock c){
        ClockNode n = new ClockNode(c);
        last.next = n;
        last = n;
        length++;
    } // append




}
