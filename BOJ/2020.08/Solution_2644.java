import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {	
	static int[][] map;
	static int[] visited;
    static int n;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		StringTokenizer str = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(str.nextToken());
		int end = Integer.parseInt(str.nextToken());
		int relation_n = Integer.parseInt(br.readLine());
		
		map = new int[n + 1][n + 1];
		visited = new int[n + 1];
		
		for (int i = 0; i < relation_n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			map[x][y] = 1;
			map[y][x] = 1;
		}

		bfs(start);
		if (visited[end] == 0) {
			System.out.println("-1");
		}
		else {
			System.out.println(visited[end]);
		}
	}
	
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);

		while (!queue.isEmpty()) {
			int x = queue.poll();

			for(int i = 1; i < map.length; i++){
				if(map[x][i] == 1 && visited[i] == 0){
					queue.add(i);
					visited[i] = visited[x] + 1;
				}
			}		
		}	
	}
}