import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Solution_17135 {
	static int N, M, D;
	static int max;
	static int[] candidate;
	static boolean[] visited;
	static boolean[][] alive;
	static ArrayList<int[]> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		max = 0;
		candidate = new int[3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		list = new ArrayList<int[]>();
		if (N >= M) {
			visited = new boolean[N];
		}
		else {
			visited = new boolean[M];
		}
		//		�������� ����� �� �̱�
		comb(M, 3, 0, 0);

		//		������ �� �ִ� ���� �ִ� �� ���ϱ�
		for (int i = 0; i < list.size(); i++) {
			int[][] copy = deepcopy(map);
			int[] archer = list.get(i);
			int enemy = 0;
			while (true) {
				if (check(copy)) {
					break;
				}

				alive = new boolean[N][M];
				//				�� ����
				for (int j = 0; j < 3; j++) {
					if (kill(archer[j], copy)) {
						enemy++;
					}
				}

				//				�� ���� -> ���� �� ǥ���ϱ�
				copy = remove(copy);

				//				�� �̵��ϱ�
				copy = remake(copy);
			}
			max = Math.max(enemy, max);
		}

		System.out.println(max);
	}

	//	�ü��� ��ġ�� �� �ִ� ����� ��
	public static void comb(int n, int m, int depth, int idx) {
		if (depth == m) {
			int[] arr = new int[m];
			for (int i = 0; i < m; i++) {
				arr[i] = candidate[i] - 1;
			}
			list.add(arr);
			return;
		}

		for (int i = idx; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				candidate[depth] = i + 1;
				comb(n, m, depth + 1, i);
				visited[i] = false;
			}
		}
	}

	public static boolean kill(int archer, int[][] map) {
		int min = N;
		int x = N;
		int y = M;
		for (int i = N - 1; i >= 0; i--) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					int dist = Math.abs(N - i) + Math.abs(j - archer);
					if (dist <= min && dist <= D) {
						if (dist == min && y > j) {
							x = i;
							y = j;
						}
						
						if (dist < min) {
							x = i;
							y = j;
						}
						min = dist;
						
						if (y == archer) {
							if (!alive[i][j]) {
								alive[i][j] = true;
								return true;
							}
							return false;
						}
					}
				}
			}
		}
		
		if (min == N) {
			return false;
		}
		
		if (!alive[x][y]) {
			alive[x][y] = true;
			return true;
		}
		return false;
	}

	//	���� �Ʒ�ĭ���� �̵�
	public static int[][] remake(int[][] map) {
		int[][] tmp = new int[N][M];

		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < M; j++) {
				tmp[i + 1][j] = map[i][j];
			}
		}

		return tmp;
	}

	//	���� �� ǥ��
	public static int[][] remove(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (alive[i][j]) {
					map[i][j] = 0;
				}
			}
		}
		return map;
	}

	//	���� ���� �ִ��� Ȯ��. ���������� false ��ȯ
	public static boolean check(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					return false;
				}
			}
		}
		return true;
	}

	public static int[][] deepcopy(int[][] map) {
		int[][] tmp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmp[i][j] = map[i][j];
			}
		}
		return tmp;
	}
}
