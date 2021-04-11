import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1068 {
	static int answer;
	static int N;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		graph = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<Integer>());
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int root = 0;
		for (int i = 0; i < N; i++) {
			int p = Integer.parseInt(st.nextToken());

			if (p == -1) {
				root = i;
				continue;
			}

			graph.get(p).add(i);
		}

		int remove = Integer.parseInt(br.readLine());

		if (root == remove) {
			System.out.println("0");
			return;
		}

		visited = new boolean[N];
		answer = 0;
		dfs(root, remove);

		System.out.println(answer);
	}

	public static void dfs(int v, int remove) {
		visited[v] = true;

		ArrayList<Integer> adj = graph.get(v);

		if (adj.contains(remove)) {
			int idx = -1;
			for (int i = 0; i < adj.size(); i++) {
				idx++;
				if (adj.get(idx) == remove) {
					break;
				}
			}
			adj.remove(idx);
		}
		
		if (adj.size() == 0) {
			answer++;
		}

		for (int i = 0; i < adj.size(); i++) {
			dfs(adj.get(i), remove);
			visited[adj.get(i)] = false;
		}
	}
}