import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class 2660_ver1 {
	static int n;
	static int[][] map;
	static int[] visited;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if (x == -1 && y == -1) {
				break;
			}
			
			map[x - 1][y - 1] = 1;
			map[y - 1][x - 1] = 1;
		}
		arr = new int[n];
		bfs();
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		int min = 10;
		for (int i = 0; i < n; i++) {
			min = Math.min(min, arr[i]);
		}
		
		for (int i = 0; i < n; i++) {
			if (min == arr[i]) {
				list.add(i + 1);
			}
		}
		
		System.out.println(min + " " + list.size());
		
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		for (int i : list) {
			sb.append(i + " ");
		}
		
		System.out.print(sb);
	}
	
	public static void bfs() {
		for (int i = 0; i < n; i++) {
			Queue<Integer> queue = new LinkedList<Integer>();
			visited = new int[n];
			queue.add(i);
			
			while (!queue.isEmpty()) {
				int x = queue.poll();
				
				for (int k = 0; k < n; k++) {
					if (i == k) {
						continue;
					}
					
					if (map[x][k] == 1 && visited[k] == 0) {
						visited[k] = visited[x] + 1;
						queue.add(k);
					}
				}
			}
			
//			visited에서 최댓값 찾기
			int max = -1;
			for (int j = 0; j < n; j++) {
				max = Math.max(max, visited[j]);
			}
			arr[i] = max;
		}
	}
}