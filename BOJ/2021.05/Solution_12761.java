import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_12761 {
	static int A, B, N, M;
	static int answer;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[100001];
		bfs();
		System.out.println(answer);
	}
	
	public static void bfs() {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(N, 0));
		visited[N] = true;
		
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int val = node.val;
			int cnt = node.cnt;
			int[] next = {val -1, val + 1, val - A, val - B, val + A, val + B, val * A, val * B};
			
			if (val == M) {
				answer = cnt;
				break;
			}
			
			for (int i = 0; i < 8; i++) {
				int nv = next[i];
				if (0 <= nv && nv < 100001 && !visited[nv]) {
					queue.add(new Node(nv , cnt + 1));
					visited[nv] = true;
				}
			}
		}
	}
}

class Node {
	int val;
	int cnt;
	
	public Node (int val, int cnt) {
		this.val = val;
		this.cnt = cnt;
	}
}