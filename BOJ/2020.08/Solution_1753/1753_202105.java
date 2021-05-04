import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[] dist;
	static ArrayList<Node>[] graph;
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(br.readLine());

		graph = new ArrayList[V + 1];
		dist = new int[V + 1];

		for (int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<Node>();
			dist[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[u].add(new Node(v, w));
		}

		dijkstra(s);

		for (int i = 1; i <= V; i++) {
			if (dist[i] != Integer.MAX_VALUE) {
				sb.append(dist[i] + "\n");
			}
			else {
				sb.append("INF\n");
			}
		}

		System.out.println(sb.toString());
	}

	public static void dijkstra(int s) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>((a, b) -> (a.w - b.w));
		pq.add(new Node(s, 0));
		dist[s] = 0;

		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int v = node.v;
			int w = node.w;

			if (dist[v] < w) {
				continue;
			}

			for (int i = 0; i < graph[v].size(); i++) {
				int new_v = graph[v].get(i).v;
				int new_w = graph[v].get(i).w;

				if (dist[v] + new_w < dist[new_v]) {
					dist[new_v] = dist[v] + new_w;
					pq.add(new Node(new_v, dist[new_v]));
				}
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