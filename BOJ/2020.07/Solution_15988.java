import java.util.Scanner;
public class Solution_15988 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		for (int i = 0; i < num; i++) {
			int x = scan.nextInt();
			System.out.println(minOp(x));
		}
	}
	
	public static long minOp (int x) {		
		long[] dp = new long[1000001];
		
		dp[1] = 1;
		
		if (x < 4) {
			for (int i = 2; i < dp.length; i++) {
				dp[i] = (dp[i - 1] * 2) % 1000000009;
			}
		}
		else {
			for (int i = 2; i < 4; i++) {
				dp[i] = (dp[i - 1] * 2)  % 1000000009;
			}
			
			for (int i = 4; i <= x; i++) {
				dp[i] = (dp[i - 3] + dp [i - 2] + dp[i - 1]) % 1000000009;
			}
		}	
		return dp[x];
	}
}