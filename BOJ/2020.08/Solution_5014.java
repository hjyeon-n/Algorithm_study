import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Solution_5014 {	
	static int[] map;
	static int[] visited;
    static int n;
    static int F, S, G, U, D;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		if (S == G) {
			System.out.println("0");
			return;
		}
		
		visited = new int[F + 1];
		bfs(S);
		
		if (visited[G] == 0) {
			System.out.println("use the stairs");
		}
		else {
			System.out.println(visited[G] - 1);
		}
	}
	
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		visited[start] = 1;

		while (!queue.isEmpty()) {
			int x = queue.poll();
			
			if (x == G) {
	            return;
	        }

			if (x + U <= F && visited[x + U] == 0) {
				queue.add(x + U);
				visited[x + U] = visited[x] + 1;
			}
			
			if (x - D > 0 && visited[x - D] == 0) {
				queue.add(x - D);
				visited[x - D] = visited[x] + 1;
			}
		}	
	}
}