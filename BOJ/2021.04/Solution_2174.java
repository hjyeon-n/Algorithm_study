import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2174 {
	static int[][] map;
	static int A, B;
	static boolean flag;
	static Node[] arr;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		map = new int[B + 1][A + 1];

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		arr = new Node[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			String val = st.nextToken();

			int d = 0;
			if (val.equals("N")) {
				d = 0;
			}
			else if (val.equals("E")) {
				d = 1;
			}
			else if (val.equals("S")) {
				d = 2;
			}
			else if(val.equals("W")) {
				d = 3;
			}

			map[y][x] = i;
			arr[i] = new Node(x, y, d);
		}

		flag = true;
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int no = Integer.parseInt(st.nextToken());
			String comm = st.nextToken();
			int step = Integer.parseInt(st.nextToken());

			move(no, comm, step);

			if (!flag) {
				return;
			}
		}

		System.out.println("OK");
	}

	public static void move(int no, String comm, int step) {
		for (int i = 0; i < step; i++) {
			Node node = arr[no];
			if (comm.equals("L") || comm.equals("R")) {
				int ndir = rotation(comm, node.dir);
				arr[no] = new Node(node.x, node.y, ndir);
			}
			else {
				int nx = node.x + dx[node.dir];
				int ny = node.y + dy[node.dir];

				if (1 <= nx && nx <= A && 1 <= ny && ny <= B) {
					if (map[ny][nx] != 0) {
						flag = false;
						System.out.println("Robot " + no + " crashes into robot " + map[ny][nx]);
						return;
					}
					else {
						arr[no] = new Node(nx, ny, node.dir);
						map[node.y][node.x] = 0;
						map[ny][nx] = no;
					}
				}
				else {
					flag = false;
					System.out.println("Robot " + no + " crashes into the wall");
					return;
				}
			}
		}
	}

	public static int rotation(String comm, int dir) {
		if (comm.equals("L")) {
			if (dir == 0) {
				dir = 3;
			} 
			else {
				dir--;
			}
		}
		else if (comm.equals("R")) {
			if (dir == 3) {
				dir = 0;
			}
			else {
				dir++;
			}
		}

		return dir;
	}
}

class Node {
	int x;
	int y;
	int dir;

	public Node (int x, int y, int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
}