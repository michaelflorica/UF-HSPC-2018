import java.util.*;

public class TigerHappiness{

    static char [][] habitat;
    static boolean[][] visited;
    //S, N, E, W,  SE, SW, NE, NW
    static int[] dx = {1, -1, 0,  0, 1,  1, -1, -1};
    static int[] dy = {0,  0, 1, -1, 1, -1,  1, -1};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int habitatCount = sc.nextInt();

        for(int h = 0; h < habitatCount; h++){

            int row = sc.nextInt();
            int col = sc.nextInt();

            habitat = new char[row][col];
            visited = new boolean[row][col];

            sc.nextLine();                  //consume newline character to process habitat cells in next loop

            //take habitat in
            for(int r = 0; r < row; r++){
                String rowBuffer = sc.nextLine();
                for(int c = 0; c < col; c++){
                    habitat[r][c] = rowBuffer.charAt(c);
                }
            }

            int totalHappiness = 0;
            for(int r = 0; r < row; r++){
                for(int c = 0; c < col; c++){
                    if(!visited[r][c]) totalHappiness += bfs(new Point(r,c));
                }
            }

            System.out.println(totalHappiness);
        }
    }

    public static int bfs(Point start){
        int row = start.row;
        int col = start.col;

        if(habitat[row][col] != 'W') return 0;

        int lakeHappiness = 1;                              //count starting point; it has to be W, otherwise we would have returned 0 in previous if;
        Queue<Point> queue = new LinkedList<Point>();
        Set<Character> uniqueAnimals = new HashSet<Character>();
        queue.add(start);
        visited[row][col] = true;

        while(!queue.isEmpty()){
            Point pointBuffer = queue.poll();

            for(int i = 0; i < 8; i++){

                int adjRow = pointBuffer.row + dx[i];
                int adjCol = pointBuffer.col + dy[i];
                int maxRow = habitat.length;
                int maxCol = habitat[0].length;

                if(adjRow < maxRow && adjCol < maxCol && adjRow >= 0 && adjCol >= 0 && !visited[adjRow][adjCol]){
                    switch(habitat[adjRow][adjCol]){
                        case 'W':
                            lakeHappiness++;
                            queue.add(new Point(adjRow,adjCol));
                            visited[adjRow][adjCol] = true;
                            break;
                        case 'B':
                            uniqueAnimals.add('B');
                            break;
                        case 'P':
                            uniqueAnimals.add('P');
                            break;
                        case 'D':
                            uniqueAnimals.add('D');
                            break;
                }

            }
        }
    }

    return lakeHappiness * (1 + uniqueAnimals.size());

    }
}

class Point{
    int row, col;

    Point(int row, int col){
        this.row = row;
        this.col = col;
    }
}
