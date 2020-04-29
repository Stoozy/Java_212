import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * @author Khademul Mahin

 *
 */

public class EditMenuHandler implements ActionListener {
    JFrame frame;
    TextArea c1, c2;

    /**
     *
     * @param frame Parent JFrame
     * @param c1    Textarea (column 1 of JFrame)
     * @param c2    Textarea (column 2 of JFrame)
     */
    public EditMenuHandler(JFrame frame, TextArea c1, TextArea c2) {
        this.frame = frame;
        this.c1 = c1;
        this.c2 = c2;
    } // constructor



    @Override
    public void actionPerformed(ActionEvent e) {
        String menuName;
        menuName = e.getActionCommand();
        if (menuName.equals("Search")){
            int hour = new Integer(0);
            try{
                hour = Integer.parseInt(JOptionPane.showInputDialog("Enter hours: "));

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null,
                        "Invalid Hour! Please enter an integer between 0 and 23");
            } catch (HeadlessException ex) {
                ex.printStackTrace();
            }
            if(hour >= 0 && hour < 24){
                search(hour);
            }else {
                JOptionPane.showMessageDialog(null,
                        "Invalid hour! Please enter a hour between 0 and 23");
            }
        }
    }// event handler

    /**
     *  Simply filters the displayed clocks
     *  for hours less than or equal to the user given hour
     *
     * @param hour Hour given by the user (int type)
     */
    public void search(int hour){
        // get textarea data
        String[] unsortedLines = c1.getText().split("\\n");
        String[] sortedLines = c2.getText().split("\\n");

        //clear textareas
        c1.setText("Unsorted\n");
        c2.setText("Sorted\n");

        // column one
        for(int i= 1; i < unsortedLines.length; i++){
            String[] u_data = unsortedLines[i].split(":");

            if(u_data[0] != null) {
                int unsorted_hour = Integer.parseInt(u_data[0]);

                // checks unsorted hour
                if (unsorted_hour <= hour) {
                    c1.append(u_data[0] + ":" + u_data[1] + ":" + u_data[2] + "\n");
                } else {
                    c1.append("");
                }
            }
        }

        // column two
        for (int i = 1; i< sortedLines.length; i++){
            String[] s_data = sortedLines[i].split(":");

            if(s_data != null){
                int sorted_hour = Integer.parseInt(s_data[0]);

                // checks sorted hour
                if( sorted_hour <= hour ){
                    c2.append(s_data[0]+":"+s_data[1] +":"+s_data[2] + "\n");
                }else {
                    c2.append("");
                }
            }

        }

    }// search

}
