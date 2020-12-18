import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, cnt;
	static int[][] map;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				if (str.charAt(j) == 'Y') {
					map[i][j] = 1;
				}
				else if (i != j){
					map[i][j] = 987654321;
				}
			}
		}
		
		for (int k = 0; k < N; k++) {
		    for (int i = 0; i < N; i++) {
		        for (int j = 0; j < N; j++) {
		        	if (i == j && j == k && i == k) {
		        		continue;
		        	}
		            if (map[i][k] + map[k][j] < map[i][j]) {
		            	map[i][j] = map[i][k] + map[k][j];
		            }
		        }
		    } 
		}
		
		int max = -1;
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if (i == j) {
					continue;
				}
				
				if (map[i][j] <= 2) {
					cnt++;
				}
			}
			max = Math.max(cnt, max);
		}
		System.out.println(max);
	}	    	
}