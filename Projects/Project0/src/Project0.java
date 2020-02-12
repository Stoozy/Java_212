// Author: Khademul Mahin

import javax.swing.*;

public class Project0 {
    public static void main(String[] args){



        while(true){
            int E=0, e=0;
            String in = JOptionPane.showInputDialog("Please enter a sentence:");
            if(in.equalsIgnoreCase("stop")){
                System.exit(0);
            }

            for(int i=0; i<in.length(); i++){
                if(in.charAt(i) == 'e') e++;
                if(in.charAt(i) == 'E') E++;
            }

            JOptionPane.showMessageDialog(null, "The number of lowercase e's: " + e +" \nThe number of uppercase e's: " + E);


        }

    }
}
