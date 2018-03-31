import java.util.*;

public class Tower{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T = Integer.parseInt(sc.nextLine());
        for(int t = 0; t < T; t++){
            String line = sc.nextLine();
            String[] time = line.split(":");

            int hr = Integer.parseInt(time[0]);
            int min = Integer.parseInt(time[1]);

            if(hr > 12)
                hr = hr - 12;

            double hrAngle = (60*hr + min)*0.5;
            double minAngle = 6*min;

            double posDiff = Math.abs(hrAngle - minAngle);
            if(posDiff > 180){
                posDiff = 360 - posDiff;
            }

            if(posDiff % 1 == 0){
                System.out.println((int)posDiff);
            }
            else{
                System.out.println(posDiff);
            }
        }
    }
}
