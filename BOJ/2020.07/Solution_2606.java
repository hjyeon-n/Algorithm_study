import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Solution_2606 {	
	static int[][] map;
	static boolean[]visited;
    static int n;
    static int cnt;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		int relation_n = Integer.parseInt(br.readLine());
		
		map = new int[n + 1][n + 1];
		visited = new boolean[n + 1];
		
		for (int i = 0; i < relation_n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			map[x][y] = 1;
			map[y][x] = 1;
		}		
		cnt = 0;
		bfs();
		
		System.out.println(cnt);
	}
	
	public static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();		
		visited[1] = true;
		queue.add(1);

		while (!queue.isEmpty()) {
			int x = queue.poll();

			for(int i = 1; i < map.length; i++){
				if(map[x][i] == 1 && !visited[i]){
					queue.add(i);
					visited[i] = true;
					cnt++;
				}
			}
			
		}	
	}
}