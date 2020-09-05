import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 1707_dfs {
	static int V, E;
	static boolean arr[];
	static ArrayList<ArrayList<Integer>> map;
	static boolean flag;
    static boolean visited[];
	public static void main(String[] args) throws NumberFormatException, IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			map = new ArrayList<>();
			for (int j = 0; j <= V; j++) { 
				map.add(new ArrayList<Integer>()); 
			}
			
			visited = new boolean[V + 1];
			arr = new boolean[V + 1];
			
			for (int j = 0; j < E; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map.get(x).add(y);
				map.get(y).add(x);
			}
			
			flag = true;
			
			for (int j = 1; j <= V; j++) {
				if (!flag) {
					break;
				}
				
				if (!visited[j]) {
					dfs(j);
				}
			}
				
			if (flag) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
	}
	
	public static void dfs(int x) {
		visited[x] = true;
		
		for (int adjV : map.get(x)) {
			if(!visited[adjV]){
				arr[adjV] = !arr[x];
				dfs(adjV);
			}
			else if (arr[x] == arr[adjV]) {
				flag = false;
				return;
			}
		}
	}
}