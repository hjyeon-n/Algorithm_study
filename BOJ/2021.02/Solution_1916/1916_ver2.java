import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 1916_ver2 {
	static ArrayList<Node>[] graph;
	static Queue<Integer> queue;
	static int[] d;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Node>();
		}
		
		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[x].add(new Node(y, w));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		d = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			if (i == start) {
				d[i] = 0;
			}
			else {
				d[i] = Integer.MAX_VALUE;
			}
		}
		
		queue = new LinkedList<Integer>();
		queue.offer(start);
		dijkstra();
		
		System.out.println(d[end]);
	}
	
	public static void dijkstra() {
		while (!queue.isEmpty()) {
			int path = queue.poll();
			
			for (Node node : graph[path]) {
				int v = node.v;
				int w = node.w;
				
				if (d[path] + w < d[v]) {
					d[v] = d[path] + w;
					queue.add(v);
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