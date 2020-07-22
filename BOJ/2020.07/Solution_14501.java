import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Solution_14501 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		int[] arr_t = new int[num + 1];
		int[] arr_p = new int[num + 1];
		int[] dp = new int[num + 1];
		
		for (int i = 1; i <= num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int period = Integer.parseInt(st.nextToken());
			int money = Integer.parseInt(st.nextToken());
			arr_t[i] = period;
			arr_p[i] = money;
			dp[i] = money;
		}
		
		for (int i = 2; i <= num; i++) {
			for (int j = 1; j < i; j++) {
				if (arr_t[j] <= i - j) {
					dp[i] = Math.max(arr_p[i] + dp[j], dp[i]);
				}
			}
		}
		
		int max = 0;
		for (int i = 1; i <= num; i++) {
			if (i + arr_t[i] <= num + 1) {
				max = Math.max(dp[i], max);
			}
		}
		
		System.out.println(max);
	}
}