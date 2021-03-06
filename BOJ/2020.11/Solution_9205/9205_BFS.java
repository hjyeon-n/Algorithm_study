import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 9205_BFS {
	static int n;
	static int[][] dist;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int caseNum = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < caseNum; i++) {
			n = Integer.parseInt(br.readLine());
			dist = new int[n + 2][n + 2];
			visited = new boolean[n + 2];
			Location[] locArr = new Location[n + 2];
			
			for (int j = 0; j < n + 2; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				locArr[j] = new Location(x, y);
			}
			
			for (int j = 0; j < n + 2; j++) {
				for (int k = 0; k < n + 2; k++) {
					dist[j][k] = Math.abs(locArr[j].x - locArr[k].x) + Math.abs(locArr[j].y - locArr[k].y);
				}
			}
			boolean rslt = bfs();
			
			if (rslt) {
				System.out.println("happy");
			}
			else {
				System.out.println("sad");
			}
		}
	}
	
	public static boolean bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(0);
		visited[0] = true;
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			
			if (x == n + 1) {
				return true;
			}
			
			for (int i = 0; i < n + 2; i++) {
                if (visited[i] == false && x != i && dist[x][i] <= 1000) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
		}
		return false;
	}
}

class Location {
	int x;
	int y;
	
	public Location (int x, int y) {
		this.x = x;
		this.y = y;
	}
}