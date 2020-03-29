/**
 * @author Khademul Mahin
 *
 * This class (project2) has a custom inputFromFile
 * method which specifically reads for hours:minutes:seconds per line
 * where hours, minutes, seconds are integers. If the input
 * doesn't meet the requirements, it gets printed out and
 * doesn't get added to the clock array.
 *
 * It instantiates, two linked lists (unsorted and sorted) and then adds
 * values to the lists with a loop that goes over every line in the argument file.
 *
 * Then it instantiates a ClockGUI, where it displays the unsorted and
 * sorted linked lists side by side in two columns.
 *
 */

import java.util.StringTokenizer;

public class Project2 {

    public static void main(String[] args){


        // Stores input from file
        String[] lines = new String[50];

        // Get input from file and store it into lines
        // Also declare the sub array size (size) to be lengthFilled
        // from the inputFromFile method
        int size = inputFromFile(args[0], lines);

        UnsortedClockList ucl = new UnsortedClockList();  // Unsorted Clock List
        SortedClockList scl = new SortedClockList();  // Sorted Clock List



        // Get all 3 variables (hours, minutes, seconds)
        // and instantiate clocks using those variables
        for(int i=0; i < size; i++ ){
            // Getting all the tokens which are the 3 variables
            StringTokenizer tokens = new StringTokenizer(lines[i], ":");
            int[] time = new int[3];

            // Parses the string into int and stores it on time[]
            int k=0;
            while(tokens.hasMoreTokens()){
                time[k] = Integer.parseInt(tokens.nextToken());
                k++;
            }

            // add clock objects to the linked lists
            ucl.add(new Clock(time[0], time[1], time[2]));
            scl.add(new Clock(time[0], time[1], time[2]));

        }




        // Instantiate the ClockGUI class as gui
        ClockGUI gui = new ClockGUI("Unsorted and Sorted Clocks");

        // For each item from each linked list, print it out on its designated column
        scl.last = scl.head;
        ucl.last = ucl.head;
        while(ucl.last.next != null){
            ucl.last = ucl.last.next;
            scl.last = scl.last.next;
            gui.c1.append(ucl.last.data.toString() + "\n");
            gui.c2.append(scl.last.data.toString() + "\n");
        }


    }


    private static int inputFromFile(String filename, String[] words){
        TextFileInput in = new TextFileInput(filename);
        int lengthFilled = 0;
        String line = in.readLine();

        while ( lengthFilled < words.length && line != null  ) {
            // Checks if there are exactly 3 tokens (hours, minutes, seconds)
            // if there isn't, then it prints out the line

            StringTokenizer tokenizer = new StringTokenizer(line, ":");
            if(tokenizer.countTokens() == 3){
                words[lengthFilled++] = line;
            }

            line = in.readLine();

        } // while

        if ( line != null) {
            System.exit(1);
        } // if

        in.close();
        return lengthFilled;
    }  // inputFromFile

}
