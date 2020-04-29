import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;


/**
 * @author Khademul Mahin
 *
 * Handles menu events such as opening a new file and quitting the application.
 *
 */


public class FileMenuHandler implements ActionListener {
    TextArea col1, col2;
    JFrame jframe;
    String[] lines = new String[500];
    // Initialize the clock lists
    UnsortedClockList ucl = new UnsortedClockList();
    SortedClockList scl = new SortedClockList();

    /**
     *
     * @param frame
     * @param ta1 is the first column
     * @param ta2 is the second column
     */
    public FileMenuHandler(JFrame frame, TextArea ta1, TextArea ta2) {
        jframe = frame;
        col1 = ta1;
        col2 = ta2;
    }


    @Override // fires events based on the menu that's clicked
    public void actionPerformed(ActionEvent e) {
        String menuName;
        menuName = e.getActionCommand();
        if (menuName.equals("Open")){
            openFile();
        }
        else if (menuName.equals("Quit"))
            System.exit(0);

    }// actionPerformed

    private void openFile() {
        // open file chooser window
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);

        // get actual size used by reading the file
        int size = readSource(chooser.getSelectedFile());

        // add the clocks to lists
        for(int i=0; i < size; i++ ){
            // Getting all the tokens which are the 3 variables (hours, minutes, seconds)
            StringTokenizer tokens = new StringTokenizer(lines[i], ":");
            int[] time = new int[3];

            // Parses the string into int and stores it on time[]
            int k=0;
            while(tokens.hasMoreTokens()){
                time[k] = Integer.parseInt(tokens.nextToken());
                k++;
            }

            try{
                Clock current_clock = new Clock(time[0], time[1], time[2]);

                // add clock objects to the linked lists
                ucl.add(current_clock);
                scl.add(current_clock);

            }catch (IllegalClockException exception){
                // do nothing because the IllegalClockException class' constructor prints the message
            }


        }

        refresh();


    }// openFile

    public  void refresh(){
        // clears and adds new files data to the columns

        col1.setText(null);
        col2.setText(null);

        col1.append("\nUNSORTED\n");
        col2.append("\nSORTED\n");

        ucl.last = ucl.head;
        scl.last = scl.head;
        while(ucl.last.next != null){
            ucl.last = ucl.last.next;
            col1.append(ucl.last.data.toString() + "\n");
            scl.last = scl.last.next;
            col2.append(scl.last.data.toString() + "\n");
        }

        jframe.setVisible(true);
    }// refresh


    private int readSource(File chosenFile)  {
        // gets the file path and starts reading the lines of that file
        String chosenFilePath = chosenFile.getAbsolutePath();
        TextFileInput in = new TextFileInput(chosenFilePath);

        String line;
        int lengthFilled = 0;

        line = in.readLine();
        while ( lengthFilled < lines.length && line != null  ) {
            // Checks if there are exactly 3 tokens (hours, minutes, seconds)
            // if there isn't, then it prints out the line

            StringTokenizer tokenizer = new StringTokenizer(line, ":");
            if(tokenizer.countTokens() == 3){
                lines[lengthFilled++] = line;
            }

            line = in.readLine();

        } // while

        if ( line != null) {
            System.exit(1);
        } // if

        in.close();

        return lengthFilled; // return the actual number of lines
    } //    readSource

}