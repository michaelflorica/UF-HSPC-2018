import java.util.*;
public class TowerShawn {

	public static void main(String[] args) {
		Scanner kb=new Scanner(System.in);

        int t=Integer.parseInt(kb.nextLine());

		for(int kk=0; kk<t;kk++){
			String s=kb.nextLine();
            String[] ab = s.split(":");

			int h=Integer.parseInt(ab[0]);

			int m=Integer.parseInt(ab[1]);
			if(h>11)h-=12;
			double ma=m*6;
			double ha=h*30+m*.5;
			double ang=ma-ha;
			if(ang<0)ang*=-1;
			if(ang>180)ang=360-ang;

            if(ang % 1 == 0){
                System.out.println((int) ang);
            }
            else{
                System.out.println(ang);
            }
		}
	}
}
