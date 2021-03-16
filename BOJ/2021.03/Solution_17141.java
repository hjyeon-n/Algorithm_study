import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Solution_17141 {
	static int N, M;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[][] visited;
	static int[] place;
	static boolean[] back;
	static ArrayList<int[]> locList;
	static ArrayList<int[]> rslt;
	static Queue<Node> queue;
	static int max, min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		locList = new ArrayList<int[]>();
		rslt = new ArrayList<int[]>();

		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 2) {
					locList.add(new int[]{i, j});
				}
			}
		}

		int size = locList.size();
		back = new boolean[size];
		place = new int[size];
		
		comb(locList.size(), M, 0, 0);
		min = Integer.MAX_VALUE;

		//		조합의 결과만큼 반복문 돌리기
		for (int i = 0; i < rslt.size(); i++) {
			queue = new LinkedList<Node>();
			visited = new boolean[N][N];
			//			map을 deepcopy
			int[][] copy = deepcopy(map);
			//			map에 바이러스 놓기
			copy = virus(copy, rslt.get(i));
			max = 0;
			//			바이러스 확산
			spread(copy);
		}

		if (min == Integer.MAX_VALUE) {
			System.out.println("-1");
		}
		else {
			System.out.println(min);
		}
	}

	public static void spread(int[][] map) {
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int x = node.x;
			int y = node.y;
			int t = node.t;
			max = Math.max(max, t);
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if (!visited[nx][ny] && map[nx][ny] == 0) {
						visited[nx][ny] = true;
						map[nx][ny] = 2;
						queue.add(new Node(nx, ny, t + 1));
					}
				}
			}
		}

		if (check(map)) {
			min = Math.min(min, max);
		}
	}

	public static boolean check(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}
	public static int[][] virus(int[][] map, int[] idx) {
		for (int i = 0; i < idx.length; i++) {
			int[] arr = locList.get(idx[i]);
			map[arr[0]][arr[1]] = -1;
			queue.add(new Node(arr[0], arr[1], 0));
		}
		return map;
	}

	public static void comb(int n, int m, int depth, int idx) {
		if (depth == m) {
			int[] arr = new int[m];
			for (int i = 0; i < m; i++) {
				arr[i] = place[i] - 1;
			}
			rslt.add(arr);
			return;
		}

		for (int i = idx; i < n; i++) {
			if (!back[i]) {
				back[i] = true;
				place[depth] = i + 1;
				comb(n, m, depth + 1, i);
				back[i] = false;
			}
		}
	}

	public static int[][] deepcopy(int[][] map) {
		int[][] tmp = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 2) {
					tmp[i][j] = 0;
				}
				else {
					tmp[i][j] = map[i][j];
				}
			}
		}
		return tmp;
	}
}

class Node {
	int x;
	int y;
	int t;

	public Node (int x, int y, int t) {
		this.x = x;
		this.y = y;
		this.t = t;
	}
}
