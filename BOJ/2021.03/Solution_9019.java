import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Solution_9019 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			bfs(A, B);
		}
	}
	
	public static void bfs(int A, int B) {
		boolean[] visited = new boolean[10000];
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(A, ""));
		visited[A] = true;

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int val = node.val;
			String cal = node.cal;
			
			int D = val * 2 % 10000;
			int S = val - 1;
			int L = (val % 1000) * 10 + val / 1000;
			int R = (val % 10) * 1000 + val / 10;   

			
			if (val == B) {
				System.out.println(cal);
				break;
			}
			
			if (!visited[D]) {
				queue.add(new Node(D, cal + "D"));
				visited[D] = true;
			}
			
			if (S < 0) {
				if (!visited[9999]) {
					queue.add(new Node(9999, cal + "S"));
					visited[9999] = true;
				}
			}
			else {
				if (!visited[S]) {
					queue.add(new Node(S, cal + "S"));
					visited[S] = true;
				}
			}
			
			if (!visited[L]) {
				queue.add(new Node(L, cal + "L"));
				visited[L] = true;
			}
			
			if (!visited[R]) {
				queue.add(new Node(R, cal + "R"));
				visited[R] = true;
			}
		}
	}
}

class Node {
	int val;
	String cal;
	
	public Node (int val, String cal) {
		this.val = val;
		this.cal = cal;
	}
}