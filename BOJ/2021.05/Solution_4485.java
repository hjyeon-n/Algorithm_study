import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_4485 {
	static int n;
	static int[][] graph;
	static int[][] dist;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = 1;
		StringBuilder sb = new StringBuilder();
		while ((n = Integer.parseInt(br.readLine())) != 0) { 
			graph = new int[n + 1][n + 1];
			dist = new int[n + 1][n + 1];
			
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					dist[i][j] = 987654321;
				}
			}
			
			for (int i = 1; i <= n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= n; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dist[1][1] = graph[1][1];
			dijkstra();
			
			sb.append("Problem " + cnt++ + ": " + dist[n][n] + "\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<Node>((a, b) -> (a.w - b.w));
		pq.add(new Node(1, 1, graph[1][1]));
		
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int x = node.x;
			int y = node.y;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx >= 1 && nx <= n & ny >= 1 && ny <= n) {
					if (graph[nx][ny] + dist[x][y] < dist[nx][ny]) {
						dist[nx][ny] = graph[nx][ny] + dist[x][y];
						pq.add(new Node(nx, ny, dist[nx][ny]));
					}
				}
			}
		}
	}
}

class Node {
	int x;
	int y;
	int w;
	
	public Node(int x, int y, int w) {
		this.x = x;
		this.y = y;
		this.w = w;
	}
}