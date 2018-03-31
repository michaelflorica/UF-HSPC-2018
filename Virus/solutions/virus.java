import java.util.*;
import java.io.*;
public class virus {

	public static void main(String[] args) {
		Scanner kb=new Scanner(System.in);
		int t=kb.nextInt();
		for(int kk=0;kk<t;kk++){
			int n=kb.nextInt();
			int p=kb.nextInt();
			boolean firewall[]=new boolean[n];
			for(int i=0;i<p;i++){
				firewall[kb.nextInt()-1]=true;
			}
			int r=kb.nextInt();
			boolean adj[][]=new boolean[n][n];
			for(int i=0;i<r;i++){
				int a=kb.nextInt()-1;
				int b=kb.nextInt()-1;
				adj[a][b]=true;
				adj[b][a]=true;
			}
			int c=kb.nextInt();
			ArrayDeque<Integer> list=new ArrayDeque<Integer>();
			for(int i=0;i<c;i++){
				list.add(kb.nextInt()-1);
			}
			boolean infected[]=new boolean[n];
			boolean visited[]=new boolean[n];
			while(!list.isEmpty()){
				int curr=list.pollFirst();
				if(!visited[curr]){
					infected[curr]=true;
					visited[curr]=true;
					for(int i=0;i<n;i++){
						if(adj[curr][i]&&!visited[i]&&!firewall[i]){
							list.add(i);
						}
					}
				}
			}
			int count=0;
			for(int i=0;i<n;i++){
				if(infected[i]){
					count++;
				}
			}
			System.out.println(count);
			
			
		}

	}

}
