import java.util.*;

public class Emergency{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T --> 0){
            int N = sc.nextInt();
            int RANGE = sc.nextInt();

            int[] housePos = new int[N];
            int antennas = 0;
            int lastLeft = Integer.MIN_VALUE;
            
            for(int house = 0; house < N; house++){
                housePos[house] = sc.nextInt();
                if(lastLeft + RANGE*2 < housePos[house]){
                    antennas++;
                    lastLeft = housePos[house];
                }
            }

            System.out.println(antennas);

        }
    }
}
