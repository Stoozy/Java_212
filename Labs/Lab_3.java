public class Lab_3{
    public static void main(String[] args){
        float f, c;
        f = 98.6f;

        for (float i =0f; i<=40; i+=5){
            c = 5f/9f * (i - 32f);
            System.out.println(c);
        }
        float j = 0f;
        while(j < 40f){

            c = 5f/9f * (j - 32f);
            System.out.println(c);
            j+=5;
        }
    }
}