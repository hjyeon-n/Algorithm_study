import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Solution_1697 {
	static int visited[];
	static int n;
	static int k;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		visited = new int[100001];
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		bfs();
	}

	public static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();	
		queue.add(n);
		visited[n] = 1;
		
		while (!queue.isEmpty()) {
			int x = queue.poll();
			if (x == k) {
				break;
			}

			if (x + 1 <= 100000 && visited[x + 1] == 0) {
				queue.add(x + 1);
				visited[x + 1] = visited[x] + 1;
			}
			
			if (x - 1 >= 0 && visited[x - 1] == 0) {
				queue.add(x - 1);
				visited[x - 1] = visited[x] + 1;
			}
			
			if (2 * x <= 100000 && visited[2 * x] == 0) {
				queue.add(2 * x);
				visited[2 * x] = visited[x] + 1;
			}
		}
		System.out.println(visited[k] - 1);
	}
}