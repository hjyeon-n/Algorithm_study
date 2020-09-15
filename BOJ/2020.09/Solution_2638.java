import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Solution_2638 {
	static int[][] map;
	static int[][] visited; 
	static int n;
	static int m;
	private static int dx[] = {0, 0, 1, -1};
    private static int dy[] = {1, -1, 0, 0};
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new int[n][m];

		int flag = 1;
		for(int i = 0; i < n; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
				if (map[i][j] == 1) {
					flag = 0;
				}
			}
		}
		
		if (flag == 1) {
			System.out.println("0");
			return;
		}

		int time=0;
        boolean check = true;
        while(check){
            visited = new int[n][m];
            bfs();
 
            check = false;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(map[i][j] != 0){
                        check = true;
                        break;
                    }
                }
            }
            time++;
        }
        System.out.println(time);
	}

	public static void bfs() {
		Queue<Location> queue = new LinkedList<Location>();
		queue.add(new Location(0, 0));
		
		while(!queue.isEmpty()) {
			Location loc = queue.poll();
			int loc_x = loc.x;
			int loc_y = loc.y;
			
			for(int i = 0; i < 4; i++){
				int nx = loc_x + dx[i];
				int ny = loc_y + dy[i];

				if(nx >= 0 && ny >= 0 && nx < n && ny < m){			
					if (map[nx][ny] == 0 && visited[nx][ny] == 0) {
						visited[nx][ny] = 1;
						queue.add(new Location(nx, ny));
					}
					
					if (map[nx][ny] == 1){
						visited[nx][ny]++;
						if (visited[nx][ny] >= 2) {
							map[nx][ny] = 0;
						}
					}
				}
			}			
		}
	}
}
class Location {
	int x, y;
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}