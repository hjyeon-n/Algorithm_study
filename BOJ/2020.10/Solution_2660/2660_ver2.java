import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class 2660_ver2 {
	static int n;
	static int[][] map;
	static boolean[] visited;
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
		int[] arr = new int[n];

		int min = 100;
		for (int i = 0; i < n; i++) {
			int max = bfs(i);
			arr[i] = max;
			min = Math.min(arr[i], min);
		}

		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			if (min == arr[i]) {
				list.add(i + 1);
			}
		}

		System.out.println(min + " " + list.size());

		StringBuilder sb = new StringBuilder();
		for (int i : list) {
			sb.append(i + " ");
		}

		System.out.print(sb);
	}

	public static int bfs(int bfs_x) {
		Queue<Point> queue = new LinkedList<Point>();
		visited = new boolean[n];
		queue.add(new Point(bfs_x, 0));
		visited[bfs_x] = true;
		int max = -1;

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			int x = p.val;
			max = Math.max(max, p.depth);
			
			for (int k = 0; k < n; k++) {
				if (map[x][k] == 1 && !visited[k]) {
					queue.add(new Point(k, p.depth + 1));
					visited[k] = true;
				}
			}
		}
		return max;
	}
}

class Point {
	int val;
	int depth;
	
	public Point(int val, int depth) {
		this.val = val;
		this.depth = depth;
	}
}