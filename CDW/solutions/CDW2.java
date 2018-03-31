import java.util.*;

public class CDW2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int t = 0; t < T; t++){
            int N = sc.nextInt();
            int E = sc.nextInt();

            int[] val = new int[N];
            int[] wt = new int[N];
            for(int i = 0; i < N; i++){
                val[i] = sc.nextInt();
                wt[i] = sc.nextInt();
            }

            System.out.println(knapsack(val, wt, E));
        }
    }

	public static int knapsack(int val[], int wt[], int W) {
        int N = wt.length; 
        int[][] V = new int[N + 1][W + 1];
        for (int col = 0; col <= W; col++) {
            V[0][col] = 0;
        }
        for (int row = 0; row <= N; row++) {
            V[row][0] = 0;
        }
        for (int item=1;item<=N;item++){
            for (int weight=1;weight<=W;weight++){
                if (wt[item-1]<=weight){
                    V[item][weight]=Math.max (val[item-1]+V[item-1][weight-wt[item-1]], V[item-1][weight]);
                }
                else {
                    V[item][weight]=V[item-1][weight];
                }
            }
        }
        return V[N][W];
    }
}
