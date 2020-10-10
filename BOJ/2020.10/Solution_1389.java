import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1389 {
	static int N;
	static int[][] map;
	static int[] visited;
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());;
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			map[p][q] = 1;
			map[q][p] = 1;
		}
		
		int min = Integer.MAX_VALUE;
		int idx = 0;
		for (int i = 1; i <= N; i++) {
			visited = new int[N + 1];
			bfs(i);
			
			int sum = 0;
			for (int j = 1; j <= N; j++) {
				sum += visited[j];
			}
			
			if (min > sum) {
				min = sum;
				idx = i;
			}
		}
		System.out.println(idx);
	}
	
	public static void bfs(int bfs_x) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(bfs_x);
		while (!queue.isEmpty()) {
			int x = queue.poll();			
			
			for (int i = 1; i <= N; i++) {
				if (visited[i] == 0 && map[x][i] == 1 && i != bfs_x) {
					visited[i] = visited[x] + 1;
					queue.add(i);
				}
			}
		}
	}
}