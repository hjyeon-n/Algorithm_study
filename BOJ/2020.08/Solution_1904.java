import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Solution_1904 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		int[] dp = new int[num + 1];
		
		dp[1] = 1;
		
		if (num > 1) {
			dp[2] = 2;
		}
		
		for (int i = 3; i <= num; i++) {
			dp[i] = (dp[i - 2] + dp[i - 1]) % 15746;
		}
		
		System.out.println(dp[num]);
	}
}