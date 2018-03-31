import java.util.*;

public class Cheers{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        while(N --> 0){
            String line = sc.nextLine();
            if(line.equals("orange")){
                System.out.println("blue");
            }
            else if(line.equals("blue")){
                System.out.println("orange");
            }
            else if(line.equals("two bits, four bits, six bits, one dollar")){
                System.out.println("all for the gators, stand up and holler!");
            }
            else if(line.equals("go gators, come on gators!")){
                System.out.println("get up and go!");
            }
        }
    }
}

/*
orange -> blue
blue -> orange
two bits, four bits, six bits, one dollar -> all for the gators, stand up and holler!
go gators, come on gators! -> get up and go!
*/
