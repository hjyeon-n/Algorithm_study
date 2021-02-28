import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1780 {
	static int[][] map;
	static int[] answer;
    public static void main(String[] args) throws IOException{
    	// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        answer = new int[] {0, 0, 0};
        
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < N; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        solution(N, 0, 0);
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < 3; i++) {
        	sb.append(answer[i] + "\n");
        }
        
        System.out.println(sb.toString());
    }
    
    public static void solution(int n, int x, int y) {
    	if (same(n, x, y)) {
    		return;
    	}
    	
    	int m = n / 3;
    	solution(m, x, y);
    	solution(m, x + m, y);
    	solution(m, x + m * 2, y);
    	
    	solution(m, x, y + m);
    	solution(m, x + m, y + m);
    	solution(m, x + m * 2, y + m);
    	
    	solution(m, x, y + m * 2);
    	solution(m, x + m, y + m * 2);
    	solution(m, x + m * 2, y + m * 2);
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
    	answer[val + 1]++;
    	return true;
    }
}