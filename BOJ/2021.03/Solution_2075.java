import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (cnt < N) {
					pq.add(map[i][j]);
					cnt++;
				}
				else {
					if (pq.peek() < map[i][j]) {
						pq.poll();
						pq.add(map[i][j]);
					}
				}
			}
		}
		
		System.out.println(pq.poll());
	}
}