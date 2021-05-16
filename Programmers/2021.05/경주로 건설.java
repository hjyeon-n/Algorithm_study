import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int n;
	static int answer;

	public static void main(String[] args){
		// TODO Auto-generated method stub

		int[][] board = {{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}};
		System.out.println(solution(board));
	}

	public static int solution(int[][] board) {
		n = board.length;
		answer = Integer.MAX_VALUE;
		map = new int[n][n];

		bfs(board);

		return answer;
	}

	public static void bfs(int[][] board) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(0, 0, 0, -1));
		map[0][0] = 1;
		
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int x = node.x;
			int y = node.y;
			int fee = node.fee;
			int direction = node.direction;

			if (x == n - 1 && y == n - 1) {
				answer = Math.min(answer, fee);
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nd = i;

				if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 0) {
					int val = 0;
					if (direction == -1 || direction == nd) {
						val = 100;
					}
					else if (direction != nd){
						val = 600;
					}
					
					int new_fee = fee + val;
					
//					처음 방문 시
					if (map[nx][ny] == 0) {
						map[nx][ny] = new_fee;
						queue.add(new Node(nx, ny, new_fee, nd));
					}
					else if (new_fee <= map[nx][ny]){
						map[nx][ny] = new_fee;
						queue.add(new Node(nx, ny, new_fee, nd));
					}
				}
			}
		}
	}
}

class Node {
	int x;
	int y;
	int fee;
	int direction;

	public Node(int x, int y, int fee, int direction) {
		this.x = x;
		this.y = y;
		this.fee = fee;
		this.direction = direction;
	}
}