import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class 1987_ver2 {
	static boolean[] alpha;
	static char[][] map;
	static int cnt, loc_cnt;
	static int R, C;
	private static int dx[] = {0, 0, 1, -1};
    private static int dy[] = {1, -1, 0, 0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		cnt = 1;
		loc_cnt = 1;
		
		map = new char[R][C];
		alpha = new boolean[26];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		alpha[map[0][0] - 'A'] = true;
		dfs(0, 0);
		System.out.println(cnt);
	}
	
	private static int dfs(int x, int y) {
		alpha[map[x][y] - 'A'] = true;
		for(int i = 0; i < 4; i++){
			int nx = x + dx[i];
			int ny = y + dy[i];

			if(nx >= 0 && ny >= 0 && nx < R && ny < C){
				if(!alpha[map[nx][ny] - 'A']){
					loc_cnt++;
					dfs(nx,ny);
					alpha[map[nx][ny] - 'A'] = false;
					cnt = Math.max(cnt, loc_cnt);
					loc_cnt--;
				}
			}
		}
		return cnt;
	}
}
class Location {
	int x, y;
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}