import java.util.*;
class Programmers {
	static int[][] visited;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	public static void main(String[] args) {
		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		System.out.println(solution(maps));
	}

	public static int solution(int[][] maps) {
		int N = maps.length;
		int M = maps[0].length;

		visited = new int[N][M];

		bfs(maps, N, M);

		if (visited[N - 1][M - 1] != 0) {
			return visited[N - 1][M - 1];
		}
		return -1;
	}

	public static void bfs(int[][] maps, int N, int M) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(0, 0));
		visited[0][0] = 1;

		while(!queue.isEmpty()) {
			Point p = queue.poll();
			int x = p.x;
			int y = p.y;

			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + x;
				int ny = dy[i] + y;

				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if (visited[nx][ny] == 0 && maps[nx][ny] == 1) {
						visited[nx][ny] = visited[x][y] + 1;
						queue.add(new Point(nx, ny));
					}
				}
			}
		}
	}
}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}