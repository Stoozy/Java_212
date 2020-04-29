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
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenuItem item;

        // Instantiate the menu handlers
        EditMenuHandler emh = new EditMenuHandler(this, ta1, ta2);
        FileMenuHandler fmh = new FileMenuHandler(this, ta1, ta2);

        // add Search to Edit menu
        item = new JMenuItem("Search");
        editMenu.add(item);
        item.addActionListener(emh);

        // add items such as  open and quit to the fileMenu
        item = new JMenuItem("Open");
        fileMenu.add(item);
        item.addActionListener(fmh);

        item = new JMenuItem("Quit");
        fileMenu.add(item);
        item.addActionListener(fmh);

        mb.add(fileMenu);
        mb.add(editMenu);
        setJMenuBar(mb); //set the menubar

    }// createMenu

}
