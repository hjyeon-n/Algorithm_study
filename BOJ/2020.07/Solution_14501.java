import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Solution_14501 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		int[] arr_t = new int[num + 2];
		int[] arr_p = new int[num + 2];
		int[] dp = new int[num + 2];

		for (int i = 1; i <= num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr_t[i] = Integer.parseInt(st.nextToken());
			arr_p[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = num; i > 0; i--) {
			int day = i + arr_t[i];
			if (day <= num + 1) {
				dp[i] = Math.max(arr_p[i] + dp[day], dp[i + 1]);
			}
			else {
				dp[i] = dp[i + 1];
			}
		}

		System.out.println(dp[1]);
	}
}