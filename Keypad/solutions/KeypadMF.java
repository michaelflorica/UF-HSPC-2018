import java.util.*;

public class KeypadMF {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while(T --> 0){
            int S = sc.nextInt();
            String[] seq = new String[S];
            TreeSet<String> pins = new TreeSet<String>();

            int shortestSeqLen = Integer.MAX_VALUE;
            int shortestSeqInd = 0;
            for(int i = 0; i < S; i++){
                seq[i] = sc.next();
                if(seq[i].length() < shortestSeqLen){
                    shortestSeqInd = i;
                    shortestSeqLen = seq[i].length();
                }
            }

            for(int i = 0; i < seq[shortestSeqInd].length() - 3; i++){
                String pin = seq[shortestSeqInd].substring(i, i+4);

                boolean inAll = true;
                for(int j = 0; j < S; j++){
                    if(j == shortestSeqInd) continue;
                    else{
                        if(!seq[j].contains(pin)){
                            inAll = false;
                        }
                    }
                }

                if(inAll){
                    pins.add(pin);
                }
            }

            for(String pin : pins){
                System.out.println(pin);
            }

            if(T != 0){
                System.out.println();
            }
        }
    }
}
