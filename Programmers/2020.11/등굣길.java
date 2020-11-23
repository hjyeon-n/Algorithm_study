public class Programmers {
	public static void main(String[] args) {
    	// TODO Auto-generated method stub
		int[][] puddles = {{2,2}};
		System.out.println(solution(4, 3, puddles));
    }
    
	public static int solution(int m, int n, int[][] puddles) {
        long[][] map = new long[n + 1][m + 1];
        
        for (int i = 0; i < puddles.length; i++) {
            int x = puddles[i][1];
            int y = puddles[i][0];
            
            map[x][y] = -1;
        }
        
        for (int i = 1; i <= m; i++) {
            if (map[1][i - 1] == -1 || map[1][i] == -1) {
                break;
            }
            map[1][i] = 1;
        }
        
        for (int i = 1; i <= n; i++) {
            if (map[i - 1][1] == -1 || map[i][1] == -1) {
                break;
            }
            map[i][1] = 1;
        }
        
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
            	if (map[i][j] == -1) {
            		continue;
            	}
                if (map[i - 1][j] != -1 && map[i][j - 1] != -1) {
                    map[i][j] = (map[i - 1][j] + map[i][j - 1]) % 1000000007;
                }
                else if (map[i - 1][j] != -1) {
                    map[i][j] = map[i - 1][j] % 1000000007;
                }
                else if (map[i][j - 1] != -1) {
                    map[i][j] = map[i][j - 1] % 1000000007;
                }
            }
        }

        return (int)(map[n][m] % 1000000007);
    }
}