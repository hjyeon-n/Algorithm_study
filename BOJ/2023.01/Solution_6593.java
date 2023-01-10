import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_6593 {
	static int L, R, C;
	static char[][][] map;
	static int[][][] visited;
    static int[] dl = {0, 0, 0, 0, 1, -1};
	static int[] dr = {0, 0, 1, -1, 0, 0};
    static int[] dc = {1, -1, 0, 0, 0, 0};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			if (L == 0 && R == 0 && C == 0) {
				break;
			}

			map = new char[L + 1][R + 1][C + 1];
			visited = new int[L + 1][R + 1][C + 1];
			Node startNode = null;
			Node endNode = null;

			for (int i = 1; i <= L; i++) {
				for (int j = 1; j <= R; j++) {
					String str = br.readLine();
					for (int k = 1; k <= C; k++) {
						char ch = str.charAt(k - 1);
						map[i][j][k] = ch;
						
						if (ch == 'S') {
							startNode = new Node(i, j, k);
						}
						
						if (ch == 'E') {
							endNode = new Node(i, j, k);
						}
					}
				}
//				한 줄 건너뛰기
				br.readLine();
			}

			bfs(startNode, endNode);
		}
	}

	public static void bfs(Node start, Node end) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(start);

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			int l = node.getL();
			int r = node.getR();
			int c = node.getC();
			
			if (l == end.getL() && r == end.getR() && c == end.getC()) {
				System.out.println("Escaped in " + visited[l][r][c] + " minute(s).");
				return;
			}

			for (int i = 0; i < 6; i++) {
				int nl = l + dl[i];
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nl >= 1 && nl <= L && nr >= 1 && nr <= R && nc >= 1 && nc <= C) {
					if (map[nl][nr][nc] == 'E' || map[nl][nr][nc] == '.') {
						if (visited[nl][nr][nc] == 0) {
							visited[nl][nr][nc] = visited[l][r][c] + 1;
							queue.add(new Node(nl, nr, nc));
						}
					}
				}
			}
		}

		System.out.println("Trapped!");
	}
}

class Node {
	private int l;
	private int r;
	private int c;

	public Node(int l, int r, int c) {
		this.l = l;
		this.r = r;
		this.c = c;
	}

	public int getL() {
		return l;
	}

	public int getR() {
		return r;
	}

	public int getC() {
		return c;
	}
}