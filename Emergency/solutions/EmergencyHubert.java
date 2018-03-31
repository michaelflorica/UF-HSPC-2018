import java.util.*;
public class EmergencyHubert {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int antennaCount = 0;
        ArrayList<Integer> antennaCountArray = new ArrayList<>();


        int numCases = sc.nextInt();

        while (numCases --> 0) {
            antennaCount = 0;

            int numHouses = sc.nextInt();
            int radius = sc.nextInt();
            ArrayList<Integer> housePositions = new ArrayList<Integer>();

            int min = 0;
            int max = 0;
            for (int i = 0; i < numHouses; i++) {
                int nextPosition = sc.nextInt();
                housePositions.add(nextPosition);
                if (i == 0) {
                    min = nextPosition;
                    max = nextPosition;
                } else {
                    if (nextPosition < min) {
                        min = nextPosition;
                    }
                    if (nextPosition > max) {
                        max = nextPosition;
                    }
                }
            }

            for (int i = 0; i < numHouses; i++) {
                housePositions.set(i, housePositions.get(i) - min);

            }
            boolean[] unCovered = new boolean[max- min + 1];

            for (int i = 0; i < unCovered.length; i++) {
                if (housePositions.contains(i)) {
                    unCovered[i] = true;

                }
            }

            while (true) {
                int nextUncoveredHouse = -1;
                for (int i = 0; i < unCovered.length; i++) {
                    if (unCovered[i]) {
                        nextUncoveredHouse = i;
                        break;

                    }
                }
                if (nextUncoveredHouse == -1) break;

                for (int i = nextUncoveredHouse; i < unCovered.length && i < nextUncoveredHouse + 2 * radius + 1; i++) {
                    unCovered[i] = false;
                }
                antennaCount++;
            }
            antennaCountArray.add(antennaCount);

        }
        for (int i = 0; i < antennaCountArray.size(); i++) {
            System.out.println(antennaCountArray.get(i));
        }



    }
}
