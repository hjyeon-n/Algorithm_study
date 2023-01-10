import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_7569 {
	static int M, N, H;
	static int[][][] map;
	static int[][][] visited;
	static int[] dh = { 0, 0, 0, 0, 1, -1 };
	static int[] dx = { 0, 0, 1, -1, 0, 0 };
	static int[] dy = { 1, -1, 0, 0, 0, 0 };
	static Queue<Node> queue;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H + 1][N + 1][M + 1];
		visited = new int[H + 1][N + 1][M + 1];
		queue = new LinkedList<Node>();

		boolean zero = false;
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= N; j++) {
				st = new StringTokenizer(br.readLine());
				int k = 1;
				while (st.hasMoreTokens()) {
					int val = Integer.parseInt(st.nextToken());
					map[i][j][k] = val;
					visited[i][j][k] = -1;
					
					if (val == 0) {
						zero = true;
					}

					if (val == 1) {
						queue.add(new Node(i, j, k));
						visited[i][j][k] = 0;
					}
					k++;
				}
			}
		}
		
		if (!zero) {
			System.out.println("0");
			return;
		}

		bfs();

		int max = -1;
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= M; k++) {
					if (map[i][j][k] == 0) {
						System.out.println("-1");
						return;
					}

					max = Math.max(visited[i][j][k], max);
				}
			}
		}

		System.out.println(max);
	}

	public static void bfs() {
		while (!queue.isEmpty()) {
			Node node = queue.poll();

			int h = node.getH();
			int x = node.getX();
			int y = node.getY();

			for (int i = 0; i < 6; i++) {
				int nh = h + dh[i];
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nh >= 1 && nh <= H && nx >= 1 && nx <= N && ny >= 1 && ny <= M) {
					if (map[nh][nx][ny] == 0 && visited[nh][nx][ny] == -1) {
						visited[nh][nx][ny] = visited[h][x][y] + 1;
						map[nh][nx][ny] = 1;
 						queue.add(new Node(nh, nx, ny));
					}
				}
			}
		}
	}
}

class Node {
	private int h;
	private int x;
	private int y;

	public Node(int h, int x, int y) {
		this.h = h;
		this.x = x;
		this.y = y;
	}

	public int getH() {
		return h;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}