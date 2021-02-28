import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2630 {
	static int[][] map;
	static int[] answer;
    public static void main(String[] args) throws IOException{
    	// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        answer = new int[]{0, 0};
        
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < N; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        solution(N, 0, 0);
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }
    
    public static void solution(int n, int x, int y) {
    	if (same(n, x, y)) {
    		return;
    	}
    	
    	solution(n / 2, x, y);
    	solution(n / 2, x, y + n / 2);
    	solution(n / 2, x + n / 2, y);
    	solution(n / 2, x + n / 2, y + n / 2);
    }
    
    public static boolean same(int n, int x, int y) {
    	int val = map[x][y];
    	
    	for (int i = x; i < x + n; i++) {
    		for (int j = y; j < y + n; j++) {
    			if (map[i][j] != val) {
    				return false;
    			}
    		}
    	}
    	answer[val]++;
    	return true;
    }
}