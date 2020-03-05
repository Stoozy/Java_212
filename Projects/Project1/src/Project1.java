import java.util.StringTokenizer;

public class Project1 {

    public static void main(String[] args){
//        Clock c = new Clock(10, 23, 50);
//        System.out.print(c.toString());
        Clock[] c = new Clock[50];


        String[] lines = new String[50];

        int size = inputFromFile(args[0], lines);
        Clock[] d = new Clock[size];
        int[] hours = new int[size];



        for(int i=0; i < size; i++ ){
            StringTokenizer tokens = new StringTokenizer(lines[i], ":");
            int[] time = new int[3];

            int k=0;
            while(tokens.hasMoreTokens()){
                time[k] = Integer.parseInt(tokens.nextToken());
                k++;
            }

            c[i] = new Clock(time[0], time[1], time[2]);

        }



        for(int j = 0; j< size; j++){
            d[j] = c[j];
            hours[j] = d[j].getHour();
            System.out.println(c[j].toString());
        }

        // Selection Sort
        int min_idx=0;

        for(int i = 0; i< size -1 ; i++){
            for(int j = i +1; j < size; j++) {
                if(hours[min_idx] < hours[j]  ){
                    min_idx = j;
                }
            }

            int temp = hours[min_idx];
            hours[min_idx] = hours[i];
            hours[i] = temp;

        }


        for(int k =0; k<size; ++k){
            System.out.println(hours[k]);
        }

    }



    private static int inputFromFile(String filename, String[] words){
        TextFileInput in = new TextFileInput(filename);
        int lengthFilled = 0;
        String line = in.readLine();
        while ( lengthFilled < words.length && line != null ) {
            words[lengthFilled++] = line;
            line = in.readLine();
        } // while
        if ( line != null ) {

            System.exit(1);
        } // if
        in.close();
        return lengthFilled;
    }  // method inputFromFile

}
