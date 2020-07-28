import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			int p_case = Integer.parseInt(br.readLine());
			long dp[] = new long[p_case + 1];
			
			if (p_case <= 3) {
				for (int j = 1; j < dp.length; j++) {
					dp[j] = 1;
				}
 			}
			else {
				dp[1] = 1;
				dp[2] = 1;
				dp[3] = 1;
				
				for (int j = 4; j < dp.length; j++) {
					dp[j] = dp[j - 3] + dp[j - 2];
				}
			}
			System.out.println(dp[p_case]);
		}
	}
}