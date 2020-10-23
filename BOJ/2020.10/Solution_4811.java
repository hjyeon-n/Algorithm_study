import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Solution_4811 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			int num = Integer.parseInt(br.readLine());
			
			if (num == 0) {
				break;
			}
			
			if (num == 0 || num == 1) {
				System.out.println("1");
			}
			else if (num == 2) {
				System.out.println("2");
			}
			else {
				long dp[] = new long[num + 1];
				dp[0] = 1;
				dp[1] = 1;
				dp[2] = 2;
				
				for (int i = 3; i <= num; i++) {
					long cnt = 0;

					for (int j = 0; j < i; j++) {
						cnt += dp[j] * dp[i - 1 - j];
					}

					dp[i] = cnt;
				}
				
				System.out.println(dp[num]);
			}
		}
	}
}