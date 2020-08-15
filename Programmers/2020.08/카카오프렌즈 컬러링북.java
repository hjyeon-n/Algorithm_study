import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Solution {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited; 
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[] answer = new int[2];
        
        visited = new boolean[m][n];
        ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(picture[i][j] != 0 && !visited[i][j]) {
					list.add(bfs(i, j, m, n, picture));					
				}
			}
		}
        numberOfArea = list.size();
        Collections.sort(list);
        maxSizeOfOneArea = list.get(numberOfArea - 1);
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    public static int bfs(int bfs_x, int bfs_y,int m, int n, int[][] picture) {
        
		Queue<Location> queue = new LinkedList<Location>();		
		visited[bfs_x][bfs_y] = true;
		queue.add(new Location(bfs_x, bfs_y));
		Location loc;

		int cnt = 1;

		while (!queue.isEmpty()) {
			loc = queue.poll();
			int x = loc.x;
			int y = loc.y;

			if (x >= m  && y >= n) {
				break;
			}

			for(int i = 0; i < 4; i++){
				int nx = x + dx[i];
				int ny = y + dy[i];

				if(nx >= 0 && ny >= 0 && nx < m && ny < n){
					if(picture[nx][ny] == picture[x][y] && !visited[nx][ny]){
						queue.add(new Location(nx, ny));
						visited[nx][ny] = true;
						cnt++;
					}
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