import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1967 {
	static boolean[] visited;
	static ArrayList<Node>[] graph;
	static int max, max_idx;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		graph = new ArrayList[n + 1];
		
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[x].add(new Node(y, w));
			graph[y].add(new Node(x, w));
		}
		
		visited = new boolean[n + 1];
		max = 0;
		max_idx = 0;
		visited[1] = true;
		dfs(1, 0);
		
		visited = new boolean[n + 1];
		max = 0;
		visited[max_idx] = true;
		dfs(max_idx, 0);
		
		System.out.println(max);
	}
	
	public static void dfs(int v, int d) {
		if (d > max) {
			max = d;
			max_idx = v;
		}
		
		for (Node node : graph[v]) {
			int next = node.v;
			int weight = node.w;
			
			if (!visited[next]) {
				visited[next] = true;
				dfs(next, d + weight);
			}
		}
	}
}

class Node {
	int v;
	int w;
	
	public Node (int v, int w) {
		this.v = v;
		this.w = w;
	}
}