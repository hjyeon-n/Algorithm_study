import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_12852 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());

		int[] dp = new int[x + 1];
		int[] trace = new int[x + 1];
		
		dp[1] = 0;
		
		for (int i = 2; i <= x; i++) {
			dp[i] = dp[i - 1] + 1;
			trace[i] = i - 1;
			
			if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
				dp[i] = dp[i / 2] + 1;
				trace[i] = i / 2;
			}
			
			if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
				dp[i] = dp[i / 3] + 1;
				trace[i] = i / 3;
			}
		}
		
		System.out.println(dp[x]);
		
		int idx = x;
		for (int i = 0; i <= dp[x]; i++) {
			System.out.print(idx + " ");
			idx = trace[idx];
		}
	}
}