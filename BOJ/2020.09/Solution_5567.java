import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5567 {
	static int[][] map;
	static boolean[] visited;
    public static void main(String[] args) throws NumberFormatException, IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	int m = Integer.parseInt(br.readLine());
    	
    	map = new int[n + 1][n + 1];
    	visited = new boolean[n + 1];
    	
    	for (int i = 0; i < m; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		map[a][b] = 1;
    		map[b][a] = 1;
    	}
    	bfs();
    	int cnt = 0;
    	for (int i = 0; i < visited.length; i++) {
    		if (visited[i]) {
    			cnt++;
    		}
    	}
    	System.out.println(cnt - 1);
    }
    
    public static void bfs() {
    	Queue<Integer> queue= new LinkedList<Integer>(); 
    	queue.add(1);
    	visited[1] = true;
    	
		for(int i = 2; i < map.length; i++){
			if(map[1][i] == 1 && !visited[i]){
				queue.add(i);
				visited[i] = true;
			}
		}		
		
		int size = queue.size();
		for (int i = 0; i < size; i++) {
			int x = queue.poll();
			for(int j = 1; j < map.length; j++){
				if(map[x][j] == 1 && !visited[j]){
					visited[j] = true;
				}
			}			
		}
	}	    	
}