import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int a, b, N, M;
	static ArrayList<Integer>[] graph;
	static int[] dist;
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		if (a == b) {
			System.out.println(0);
			return;
		}
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); 
		
		graph = new ArrayList[N + 1];
		dist = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			graph[i] = (new ArrayList<Integer>());
			dist[i] = 987654321;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken()); 
			
			graph[x].add(y);
			graph[y].add(x);
		}
		
		dijkstra();
		
		if (dist[b] == 987654321) {
			System.out.println(-1);
		}
		else {
			System.out.println(dist[b]);
		}
	}
	
	public static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<Node>((a , b) -> (a.d - b.d));
		dist[a] = 0;
		pq.add(new Node(a, 0));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			int val = node.val;
			int d = node.d;
			
			if (dist[val] < d) {
				continue;
			}
			
			for (int i : graph[val]) {
				if (d + 1 < dist[i]) {
					dist[i] = d + 1;
					pq.add(new Node(i, dist[i]));
				}
			}
		}
	}
}

class Node {
	int val;
	int d;
	
	public Node (int val, int d) {
		this.val = val;
		this.d = d;
	}
}