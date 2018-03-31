import java.util.*;

public class CDW{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        for(int t = 0; t< T; t++){
            int N = sc.nextInt();
            int W = sc.nextInt();
            int val[] = new int[N];
            int wt[] = new int[N];

            for(int i = 0; i < N; i++){
                val[i] = sc.nextInt();
                wt[i] = sc.nextInt();
            }

            int n = val.length;

            System.out.println(knapSack(W, wt, val, n));
        }
    }

    static int knapSack(int W, int wt[], int val[], int n)
    {
        if (n == 0 || W == 0)
            return 0;

        if (wt[n-1] > W)
            return knapSack(W, wt, val, n-1);

        else{
            return Math.max( val[n-1] + knapSack(W-wt[n-1], wt, val, n-1), knapSack(W, wt, val, n-1));
        }
    }
}
