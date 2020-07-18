import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Solution_2579 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] stair = new int[n + 1];
		int[] dp = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = stair[1];
		
		if (n >= 2) {
			dp[2] = dp[1] + stair[2];
		}
		for (int i = 3; i <= n; i++) {
			dp[i] = stair[i] + Math.max(dp[i - 2], stair[i - 1] + dp[i - 3]);
		}
		System.out.println(dp[n]);
	}
}