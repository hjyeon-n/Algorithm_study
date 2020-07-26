import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Solution_2163 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		System.out.println(slice(x, y));
	}
	
	public static int slice (int x, int y) {		
		int[][] dp = new int[x + 1][y + 1];
		
		dp[1][1] = 0;
		
		int i = 2;
		int j = 2;
		
		if (x == 1) {
			while (j <= y) {
				dp[1][j] = dp[1][j - 1] + 1;
				j++;	
			}
		}
		else {
			while (i <= x) {
				while (j <= y) {
					dp[1][j] = dp[1][j - 1] + 1;
					j++;	
				}
				
				dp[i][y] = dp[i - 1][y] + y;
				i++;
			}
		}
		
		return dp[x][y];
	}
}