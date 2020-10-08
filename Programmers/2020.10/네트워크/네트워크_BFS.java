import java.util.LinkedList;
import java.util.Queue;

public class Programmers {
	static boolean[] visited;
	public static void main(String[] args) {
    	// TODO Auto-generated method stub
    	int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
    	System.out.println(solution(3, computers));
    }
    
    public static int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1 && !visited[i]) {
                    bfs(i, computers);
                    answer++;
                } 
            }
        }
        return answer;
    }
    
    public static void bfs(int x, int[][] computers) {
    	Queue<Integer> queue = new LinkedList<Integer>();
    	queue.add(x);
    	visited[x] = true;
    	
    	while(!queue.isEmpty()) {
    		int nx = queue.poll();
    		for (int i = 0; i < computers.length; i++) {
    			if (computers[nx][i] == 1 && !visited[i]) {
    				queue.add(i);
    				visited[i] = true;
    			}
    		}
    	}
    }
}