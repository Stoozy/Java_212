/**
 * @Author: Khademul Mahin
 *
 * This class (project1) has a custom inputFromFile
 * method which specifically reads for hours:minutes:seconds
 * where hours, minutes, seconds are integers. If the input
 * doesn't meet the requirements, it gets printed out and
 * doesn't get added to the clock array.
 *
 * The main function instantiates the Clock class twice.
 * One of which are sorted and the other one is not.
 *
 * It also instantiates a ClockGUI,
 * where it displays the unsorted and
 * sorted Clock arrays side by side
 * in two columns.
 *
 *
 */

import java.util.StringTokenizer;

public class Project1 {

    public static void main(String[] args){


        // Stores input from file
        String[] lines = new String[50];

        // Get input from file and store it into lines
        // Also declare subArraySize (size) to be lengthFilled
        // from the inputFromFile method
        int size = inputFromFile(args[0], lines);

        Clock[] c = new Clock[size];        // Original Clock Array
        Clock[] d = new Clock[size];        // Sorted Clock Array


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
            c[i] = new Clock(time[0], time[1], time[2]);


        }

        // copies c elements over to d
        for(int i = 0; i< size; i++){
            d[i] = c[i];
        }


        // Selection Sort d[]
        for(int i=0; i < (size -1); i++ ){
            int min_idx=i;

            for(int j= (i+1) ; j < size; j++){

                // Check the hour of each clock since we are sorting by hour
                if(d[min_idx].getHour() > d[j].getHour()) {
                    min_idx = j;
                }
            }
            // Swap the lowest value to current position/index (i)
            if(d[min_idx].getHour() != d[i].getHour()){
                Clock temp = d[min_idx];
                d[min_idx] = d[i];
                d[i] = temp;
            }

        }

        // Instantiate the ClockGUI class as gui
        ClockGUI gui = new ClockGUI("Unsorted and Sorted Clocks");

        // For each item from c[] and d[], print it out on its designated column
        for(int i =0; i< size; i++){
            gui.c1.append(c[i].toString() + "\n");
            gui.c2.append(d[i].toString() + "\n");
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
            else{
                System.out.println(line);
            }
            line = in.readLine();

        } // while

        if ( line != null) {
            System.exit(1);
        } // if

        in.close();
        return lengthFilled;
    }  // method inputFromFile

}
