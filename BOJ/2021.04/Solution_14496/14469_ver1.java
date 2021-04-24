import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int a, b, N, M, answer;
	static int[][] map;
	static boolean[] visited;
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
		
		answer = 987654321;
		map = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			map[x][y] = 1;
			map[y][x] = 1;
		}
		
		bfs();
		
		if (answer == 987654321) {
			System.out.println(-1);
		}
		else {
			System.out.println(answer);
		}
	}
	
	public static void bfs() {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(a, 0));
		visited[a] = true;
		
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			
			int val = node.val;
			int cnt = node.cnt;
			
			if (val == b) {
				answer = Math.min(answer, cnt);
				break;
			}
			
			for (int i = 1; i <= N; i++) {
				if (map[val][i] == 1 && !visited[i]) {
					visited[i] = true;
					queue.add(new Node(i, cnt + 1));
				}
			}
		}
	}
}

class Node {
	int val;
	int cnt;
	
	public Node(int val, int cnt) {
		this.val = val;
		this.cnt = cnt;
	}
}