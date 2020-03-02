

import javax.swing.*;

/**
 * @author Khademul Mahin
 *
 * The class: Project0 contains a main method that asks for user input
 * and tells the user how many lowercase and uppercase e's were in the users input text.
 */
public class Project0 {
    public static void main(String[] args){
        while(true){
            int E=0, e=0;   // initialize E, and e to be 0
            // E counts the number of uppercase e's
            // e counts the number of lowercase e's

            String in = JOptionPane.showInputDialog("Please enter a sentence:");
            // gets input from user and stores it in String type variable called in;

            if(in.equalsIgnoreCase("stop")){
                System.exit(0);
            }// Immediately stop the program if user enters the word stop in any case

            for(int i=0; i<in.length(); i++){
                if(in.charAt(i) == 'e') e++;
                if(in.charAt(i) == 'E') E++;
            }// Increases e and E based on the string the user entered
            // e increases if the for loop finds an 'e' char in the string
            // E increases if the for loop finds an 'E' char in the string

            JOptionPane.showMessageDialog(null, "The number of lowercase e's: " + e +" \nThe number of uppercase e's: " + E);
            // show the results in a message dialog from JOptionPane

        }// Repeat (End of while loop)

    }// End of main method

}// End of class
