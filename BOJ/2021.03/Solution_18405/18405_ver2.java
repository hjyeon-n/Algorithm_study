import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 18405_ver2 {
	static int[][] map;
	static boolean[][] visited;
	static Queue<Node> queue;
	static int N;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		visited = new boolean[N][N];
		queue = new LinkedList<Node>();

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0) {
					min = Math.min(min, map[i][j]);
				}
			}
		}

		st = new StringTokenizer(br.readLine());

		int S = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());

		int order = min;
		while (true) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == order && !visited[i][j]) {
						queue.add(new Node(i, j, 0));
						visited[i][j] = true;
					}
				}
			}

			if (order == K) {
				bfs(S);
				break;
			}

			order++;
		}

		System.out.println(map[X - 1][Y - 1]);
	}

	public static void bfs(int S) {
		while (!queue.isEmpty()) {
			Node node = queue.poll();

			int a = node.a;
			int b = node.b;
			int t = node.t;
			
			if (t == S) {
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = a + dx[i];
				int ny = b + dy[i];

				if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if (map[nx][ny] == 0 && !visited[nx][ny]) {
						map[nx][ny] = map[a][b];
						visited[nx][ny] = true;
						queue.add(new Node(nx, ny, t + 1));
					}
				}
			}
		}
	}
}

class Node {
	int a;
	int b;
	int t;

	public Node(int a, int b, int t) {
		this.a = a;
		this.b = b;
		this.t = t;
	}
}