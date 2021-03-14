import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_13023 {
	static boolean answer;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<ArrayList<Integer>>();
		visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		for (int i = 0; i < N; i++) {
			dfs(i, 0, N);
			
			if (answer) {
				break;
			}
		}
		
		if (answer) {
			System.out.println("1");
		}
		else {
			System.out.println("0");
		}
	}
	
	public static void dfs(int node, int depth, int N) {
		if (depth >= 4) {
			answer = true;
			return;
		}
		
		visited[node] = true;
		for (int i = 0; i < graph.get(node).size(); i++) {
			if (!visited[graph.get(node).get(i)]) {
				visited[graph.get(node).get(i)] = true;
				dfs(graph.get(node).get(i), depth + 1, N);
				visited[graph.get(node).get(i)] = false;
			}
		}
		visited[node] = false;
	}
}