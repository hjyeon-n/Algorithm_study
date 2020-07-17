import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
public class Solution_1793 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		while ((input = br.readLine()) != null) {
			if (input.equals("")) {
				break;
			}
			int num = Integer.parseInt(input);
			BigInteger[] dp = new BigInteger[num + 1];
			
			dp[0] = BigInteger.ONE;
			
			if (num >= 1) {
				dp[1] = BigInteger.ONE;
			}
			
			if (num > 1) {
				dp[2] = new BigInteger("1").add(new BigInteger("2"));
			}
			
			for (int i = 3; i <= num; i++) {
				dp[i] = (new BigInteger("2")).multiply(dp[i - 2]).add(dp[i - 1]);
			}
			
			System.out.println(dp[num]);
		}
	}
}