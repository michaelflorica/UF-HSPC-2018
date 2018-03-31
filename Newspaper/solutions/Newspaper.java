import java.util.*;

public class Newspaper{

	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T --> 0){
            double N = sc.nextInt();
            double S = sc.nextInt();
            double L = sc.nextInt();
            double W = sc.nextInt();

            double minSmallPages = Math.ceil(W/S);

            //if article takes more pages than you afford (N)
            //if only small font is used, then answer is -1
            if(minSmallPages > N){
                System.out.println("-1");
            }

            else{
                int minLargePages = 0;
                int maxLargePages = (int)Math.ceil(W/L);

                int answer = 0;

                while(minLargePages <= maxLargePages){

                    int mid = (maxLargePages + minLargePages)/2;

                    if(mid + (W - (double)mid*L)/S <= N){
                        answer = mid;
                        minLargePages = mid+1;
                    }

                    else{
                        maxLargePages = mid-1;
                    }
                }

                System.out.println(answer);

            }
        }
	}
}
