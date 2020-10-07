import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int max;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int ex[][] = {{0, 0, 0, 1}, {0, 1, 2, 1}, {0, 0, 0, -1}, {0, -1, 0, 1}};
    static int ey[][] = {{0, 1, 2, 1}, {0, 0, 0, 1}, {0, 1, 2, 1}, {0, 1, 1, 1}};
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		max = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				DFS(i, j, 0, 0);
				special(i, j);
			}
		}
		System.out.println(max);
	}
	
	public static void DFS(int x, int y, int depth, int sum) {
		if (depth == 4) {
			max = Math.max(max, sum);
			return;
		}
	 
		for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                if (visited[nx][ny] != true) {
                    visited[nx][ny] = true;
                    DFS(nx, ny, depth + 1, sum + map[nx][ny]);
                    visited[nx][ny] = false;
                }
            }
        }
	}
	
	public static void special(int x, int y) {
		for(int i = 0; i < 4; i++){
            int sum = 0;

            for(int j = 0; j < 4; j++){
                int nx = x + ex[i][j];
                int ny = y + ey[i][j];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
                	sum += map[nx][ny];
                }
            }
            max = Math.max(max, sum);
        }
	}
}