import java.util.Scanner;
public class Solution_1463 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		System.out.println(minOp(num));
	}
	
	public static int minOp (int x) {
		
		int[] dp = new int[x + 1];
		int ret = 0;
		
		for (int i = 0; i < dp.length; i++) {
			dp[i] = 0;
		}
		
		for (int i = 2; i <= x; i++) {
			int local_min = x + 1;
			if (i % 3 == 0) {
				ret = dp[i/3] + 1;
				local_min = (local_min > ret)?ret:local_min;
			}
			
			if (i % 2 == 0) {
				ret = dp[i/2] + 1;
				local_min = (local_min > ret)?ret:local_min;
			}
			
			ret = dp[i - 1] + 1;
			
			local_min = (local_min > ret)?ret:local_min;
			dp[i] = local_min;
		}
		return dp[x];
	}
}