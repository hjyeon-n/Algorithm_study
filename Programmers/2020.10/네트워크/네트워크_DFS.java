public class Programmers {
	static boolean[] visited;
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
    	int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
    	System.out.println(solution(3, computers));
    }
    
    public static int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1 && !visited[i]) {
                    dfs(i, computers);
                    answer++;
                } 
            }
        }
        return answer;
    }
    
    public static void dfs(int x, int[][] computers) {
        visited[x] = true;
        for (int i = 1; i < computers.length; i++) {
        	if(computers[x][i] == 1 && !visited[i]){
        		dfs(i, computers);
        	}
        }
    }
}