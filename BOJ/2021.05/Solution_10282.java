import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_10282 {
	static int[] dist;
	static ArrayList<Node>[] graph;
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph = new ArrayList[n + 1];
			dist = new int[n + 1];

			for (int j = 1; j <= n; j++) {
				graph[j] = new ArrayList<Node>();
				dist[j] = Integer.MAX_VALUE;
			}

			for (int j = 0; j < d; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());

				graph[b].add(new Node(a, s));
			}

			dijkstra(c);

			int max = 0;
			int cnt = 0;
			for (int j = 1; j <= n; j++) {
				if (dist[j] != Integer.MAX_VALUE) {
					max = Math.max(max, dist[j]);
					cnt++;
				}
			}
			
			sb.append(cnt + " " + max + "\n");
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