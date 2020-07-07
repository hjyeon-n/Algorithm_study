import java.util.Scanner;
public class problem_9095 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		for (int i = 0; i < num; i++) {
			int x = scan.nextInt();
			System.out.println(minOp(x));
		}
	}
	
	public static int minOp (int x) {		
		int[] dp = new int[x + 1];
		int ret = 0;
		
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