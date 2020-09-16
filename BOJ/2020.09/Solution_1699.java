import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[100001];
		
		for (int i = 1; i <= n; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		
		for (int i = 1; i <= 3; i++) {
			dp[i] = i;
		}
		
		int cnt = 2;
		for (int i = 4; i <= n; i ++) {
			if (Math.pow(cnt, 2) == i) {
				dp[i] = 1;
				cnt++;
				continue;
			}
			int tmp = cnt;
			while (tmp > 1) {
				int val = tmp * tmp;
				dp[i] = Math.min(dp[i], i / val + dp[(i % val)]);
				tmp--;
			}
		}
		System.out.println(dp[n]);
	}
}