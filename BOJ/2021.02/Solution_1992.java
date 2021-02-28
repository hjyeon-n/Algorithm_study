import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1992 {
	static int[][] map;
	static String str;
    public static void main(String[] args) throws IOException{
    	// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        str = "";
        
        for (int i = 0; i < N; i++) {
        	String input = br.readLine();
        	for (int j = 0; j < N; j++) {
        		map[i][j] = input.charAt(j) - '0';
        	}
        }
        
        solution(N, 0, 0);
        
        System.out.println(str);
    }
    
    public static void solution(int n, int x, int y) {
    	if (same(n, x, y)) {
    		str += map[x][y];
    		return;
    	}
    	
    	str += "(";
    	solution(n / 2, x, y);
    	solution(n / 2, x, y + n / 2);
    	solution(n / 2, x + n / 2, y);
    	solution(n / 2, x + n / 2, y + n / 2);
    	str += ")";
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
    	return true;
    }
}