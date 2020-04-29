import java.util.Comparator;

/**
 * Simple comparator class that compares clocks
 */
public class ClockComparator implements Comparator<Clock> {

    /**
     *
     * @param o1 clock one
     * @param o2 clock two
     * @return comparison result (int type)
     */
    @Override
    public int compare(Clock o1, Clock o2) {
        //clocks know how to compare so just return the result from calling that method
        return o1.compareTo(o2);

    }// compare

}
