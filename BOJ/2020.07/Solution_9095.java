import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_9095 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < num; i++) {
			int x = Integer.parseInt(br.readLine());
			System.out.println(minOp(x));
		}
	}
	
	public static int minOp (int x) {		
		int[] dp = new int[x + 1];
		
		dp[1] = 1;
		
		if (x < 4) {
			for (int i = 2; i < dp.length; i++) {
				dp[i] = dp[i - 1] * 2;
			}
		}
		else {
			for (int i = 2; i < 4; i++) {
				dp[i] = dp[i - 1] * 2;
			}
			
			for (int i = 4; i <= x; i++) {
				dp[i] = dp[i - 3] + dp [i - 2] + dp[i - 1];
			}
		}	
		return dp[x];
	}
}