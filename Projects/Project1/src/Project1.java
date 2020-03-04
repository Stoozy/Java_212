public class Project1 {

    public static void main(String[] args){
        Clock c = new Clock(10, 23, 50);
//        System.out.print(c.toString());

        String[] lines = new String[50];

        inputFromFile(args[0], lines);

        for(int i=0; i < inputFromFile(args[0], lines); i++ ){
            System.out.println(lines[i]);
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
