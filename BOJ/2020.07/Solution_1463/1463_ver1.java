import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class 1463_ver1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
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