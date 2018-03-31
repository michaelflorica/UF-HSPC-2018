import java.util.*;

public class NewspaperN{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while(T --> 0){
            double N = sc.nextInt();
            double S = sc.nextInt();
            double L = sc.nextInt();
            double W = sc.nextInt();

            if(Math.ceil(W / S) > N){
                System.out.println("-1");
            }

            else{
                int largestNumLargePages = 0;

                for(int i = 0; i <= (int)Math.ceil(W/L); i++){
                    
                    double wordsTaken = i*L;
                    double pagesRemaining = N-i;
                    double wordsRemaining = W - wordsTaken;

                    if(Math.ceil(wordsRemaining/S) <= pagesRemaining){
                        largestNumLargePages = i;
                    }

                }

                System.out.println(largestNumLargePages);
            }
        }
    }
}
