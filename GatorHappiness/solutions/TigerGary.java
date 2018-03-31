import java.util.*;
import java.io.*;
import java.awt.Point;

public class TigerGary {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s;
        if (args.length > 0) {
            try {
                s = new Scanner(new File(args[0]));
                test(s);
            } catch (FileNotFoundException e) {
                throw e;
            }
        }
        else {
            s = new Scanner(System.in);
            test(s);
        }
        
    }
    public static void test(Scanner s) {
        int T = s.nextInt(); // num tests
        while (T --> 0) {
            solve(s);
        }
    }

    public static void solve(Scanner s) {
        int H = s.nextInt();
        int W = s.nextInt();
        s.nextLine();

        List<Lake> lakes = new ArrayList<Lake>();

        char[][] map = new char[H][W];
        boolean[][] visited = new boolean[H][W];
        
        // construct map
        for (int i = 0; i < H; i++) {
            map[i] = s.nextLine().toCharArray();
            
            // initialize visited array
            for (int j = 0; j < W; j++) {
                visited[i][j] = false;
            }
        }

        // traverse array 
        // and do bfs at each unvisited water square
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == 'W' && !visited[i][j]) {
                    Lake lake = new Lake();
                    updateLake(lake, new Point(i, j), map, visited, H, W);
                    lakes.add(lake);
                }
            }
        }
    
        System.out.println(scoreLakes(lakes));
    }

    /** Return sum of scores of all Lakes in a List<Lake> */
    public static int scoreLakes(List<Lake> lakes) {
        int score = 0;
        for (Lake lake : lakes) {
            score += lake.getScore();
        }
        return score;
    }

    /** Calculate size and number of animals for an unvisited Lake */
    public static void updateLake(Lake lake, Point start, char[][] map, boolean[][] visited, int H, int W) {
        int size = 0;
        Queue<Point> q = new LinkedList<Point>();
        q.add(start);

        // bfs
        while (!q.isEmpty()) {
            Point curr = q.poll();
            int i = curr.x;
            int j = curr.y;
            
            if (map[i][j] == 'L') {
                continue; // if land, ignore
            } else if (map[i][j] != 'W') { 
                // if an animal, add current lake to this animal
                char animalName = map[i][j];
                switch(animalName) {
                    case 'B':
                        lake.B += 1;
                        break;
                    case 'D':
                        lake.D += 1;
                        break;
                    case 'P':
                        lake.P += 1;
                }
            } else {

                if (visited[i][j]) continue;
                visited[i][j] = true;
                size += 1;

                // iterate through neighbors
                for (int di = -1; di <= 1; di++) {
                    for (int dj = -1; dj <= 1; dj++) {
                        if (di == 0 && dj == 0) continue;
                        if (i+di < 0 || i+di >= H || j+dj < 0 || j+dj >= W) continue;

                        q.add(new Point(i+di, j+dj));
                    }
                }
            }
        }

        lake.size = size;
    }

    /** Stores lake size and number of animals of each kind. */
    static class Lake {
        public int size = 0;
        public int B = 0;
        public int P = 0;
        public int D = 0;
        public Lake() {}
        public int getScore() {
            int numDifferentAnimals = 0;
            if (B > 0) numDifferentAnimals++;
            if (P > 0) numDifferentAnimals++;
            if (D > 0) numDifferentAnimals++;
            return size * (1 + numDifferentAnimals);
        }
    }
}