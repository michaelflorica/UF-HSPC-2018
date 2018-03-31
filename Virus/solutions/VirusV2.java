import java.util.*;

public class VirusV2{

	public static ArrayList<ArrayList<Integer>> adjacency;
	public static boolean[] vaccinated;

    public static ArrayList<Integer> infected;

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
        infected = new ArrayList<Integer>();

		while(T --> 0){
			int N = sc.nextInt();

			vaccinated = new boolean[N+1];
			adjacency = new ArrayList<ArrayList<Integer>>();
			for(int i = 0; i <= N+1; i++){
				adjacency.add(new ArrayList<Integer>());
			}

			int V = sc.nextInt();
			for(int v = 0; v < V; v++){
				vaccinated[sc.nextInt()] = true;
			}

			int R = sc.nextInt();
			for(int r = 0; r < R; r++){
				int a = sc.nextInt();
				int b = sc.nextInt();
				adjacency.get(a).add(b);
				adjacency.get(b).add(a);
			}

			int ans = 0;
			boolean visited[] = new boolean[N+1];

			int I = sc.nextInt();
			for(int i = 0; i < I; i++){
				int start = sc.nextInt();
				ans += dfs(start,visited);
			}

            Collections.sort(infected);
            //for(int i = 0; i < infected.size(); i++){
//
 //               System.out.println("INFECTED : " + infected.get(i));
  //          }

			System.out.println(ans);
		}

	}

	public static int dfs(int start, boolean visited[]){

		int ans = 0;
		if(vaccinated[start] || visited[start]) return ans;

		ans += 1;
        infected.add(start);
		visited[start] = true;

		for(int i = 0; i < adjacency.get(start).size(); i++){
			if(!visited[adjacency.get(start).get(i)]){
				ans += dfs(adjacency.get(start).get(i),visited);
			}
		}

		return ans;
	}

}
