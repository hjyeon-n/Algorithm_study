import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_2210 {
	static HashSet<String> set;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static String str;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new int[5][5];
		set = new HashSet<String>();

		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				dfs(i, j, String.valueOf(map[i][j]));
			}
		}

		System.out.println(set.size());
	}

	public static void dfs(int x, int y, String str) {
		if (str.length() == 6) {
			set.add(str);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;

			if (nx < 5 && nx >= 0 && ny < 5 && ny >= 0) {
				dfs(nx, ny, str + String.valueOf(map[nx][ny]));
			}
		}
	}
}