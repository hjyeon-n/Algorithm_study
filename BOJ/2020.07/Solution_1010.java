import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Solution_1010 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		for (int loop = 1; loop <= num; loop++) { 
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int [][] dp = new int[n + 1][m + 1];

			for (int j = 1; j <= m; j++) {
				dp[1][j] = j;
			}
			
			for (int i = 2; i <= n; i++) {
				for (int j = i; j <= m; j++) {
					dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
				}
			}
			
			System.out.println(dp[n][m]);
		}
	}
}