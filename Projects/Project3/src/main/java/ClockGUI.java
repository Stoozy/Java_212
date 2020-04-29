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
    TextArea ta1 = new TextArea();
    TextArea ta2 = new TextArea();

    public ClockGUI(){
        // some initial jframe options
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new GridLayout(1,2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // add the columns to the frame
        add(ta1);
        add(ta2);
        createMenu();

    }// constructor

    public void createMenu(){
        JMenuBar mb = new JMenuBar();
        JMenu menu = new JMenu("File");

        // Instantiate the file menu handler
        FileMenuHandler fmh = new FileMenuHandler(this, ta1, ta2);
        JMenuItem item;

        // add items such as  open and quit to the menu
        item = new JMenuItem("Open");
        menu.add(item);
        item.addActionListener(fmh);
        item = new JMenuItem("Quit");
        menu.add(item);
        item.addActionListener(fmh);

        mb.add(menu);
        setJMenuBar(mb); //set the menubar

    }// createMenu

}
