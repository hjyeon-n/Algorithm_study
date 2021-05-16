
public class Main {
	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
		System.out.println(solution(5, results));
	}
	
	public static int solution(int n, int[][] results) {
        int[][] map = new int[n + 1][n + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    map[i][j] = 0;
                }
                else {
                    map[i][j] = 987654321;
                }
            }
        }
        
        for (int i = 0; i < results.length; i++) {
            int x = results[i][0];
            int y = results[i][1];
            
            map[x][y] = 1;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    map[a][b] = Math.min(map[a][b], map[a][i] + map[i][b]);
                }
            }   
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (map[i][j] != 987654321 || map[j][i] != 987654321) {
                    cnt++;
                }
            }
            
            if (cnt == n) {
                answer++;
            }
        }
        
        return answer;
    }
}