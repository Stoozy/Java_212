/**
 * @author  Khademul Mahin
 *
 *  SortedClockList extends ClockList but has a custom
 *  add method which inserts the item to the linked list
 *  such that the linked list remains sorted.
 */

public class SortedClockList extends ClockList{

    public SortedClockList(){
    }// empty constructor

    public void add(Clock c){
        ClockNode n = new ClockNode(c);

        //  exception for head, since it starts the list,
        //  if the last node is head, then just simply reference n as the next node
        //  and move the pointer last to the next node
        if(last == head ){
            last.next = n;
            last = last.next;
            length++;
        }else{
            // start from the beginning
            last = head;

            // traverse the list to find a value that is greater than the new node (n)
            while(last.next != null && last.next.data.getHour() <= n.data.getHour()){
                last = last.next;
            }
            // new node references last.next as the next node
            // and the last node references n as the next node
            n.next = last.next;
            last.next = n;

            // traverse the list so that last refers to the last node
            while(last.next != null){
                last = last.next;
            }

            // increase length of the list
            length++;
        }

    } // add



}



