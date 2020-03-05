import javax.swing.*;
import java.awt.*;

/**
 * @Author: Khademul Mahin
 *
 * The ClockGUI class provides a JFrame
 * with two columns where data can be shown.
 *
 *
 */
public class ClockGUI extends JFrame {

    // We only need two TextAreas for two columns of data
    TextArea c1 = new TextArea();
    TextArea c2 = new TextArea();


    public ClockGUI(String title){
        // some initial values
        setSize(400, 500);
        setTitle(title);
        setLayout(new GridLayout(1,2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // add the columns to the JFrame (this)
        this.add(c1);
        this.add(c2);

        // Specify which is sorted and unsorted
        c1.append("UNSORTED\n");
        c2.append("SORTED\n");

    }


}
