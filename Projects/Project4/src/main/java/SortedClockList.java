import java.util.TreeMap;

/**
 * @author  Khademul Mahin
 *
 *  SortedClockList has a treemap containing all the clocks which are automatically sorted.
 *
 *
 */

public class SortedClockList{

    // Instantiate the treemap with the clockcomparator so the treemap stays sorted
    TreeMap<Clock, Integer> sortedMap = new TreeMap<>( new ClockComparator());

    public SortedClockList(){
    }// empty constructor

    /**
     *
     * @param o Clock which is read from file
     * @param i Index
     */
    public void put(Clock o, Integer i){
        sortedMap.put(o, i);
    }

    /**
     * @return the sorted map is returned
     */
    public TreeMap<Clock, Integer> getSortedMap(){
        return sortedMap;
    }

}



