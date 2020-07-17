import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Solution_1149 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		int arr[][] = new int[num + 1][4];
		int dp[][] = new int[num + 1][4];
		
		for (int i = 1; i <= num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 3; j++) {
				if (st.hasMoreTokens()) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}

		for (int j = 1; j <= 3; j++) {
			dp[1][j] = arr[1][j];
		}

		for (int i = 2; i <= num; i++) {
			dp[i][1] = arr[i][1] + Math.min(dp[i - 1][2], dp[i - 1][3]);
			dp[i][2] = arr[i][2] + Math.min(dp[i - 1][1], dp[i - 1][3]);
			dp[i][3] = arr[i][3] + Math.min(dp[i - 1][1], dp[i - 1][2]);
		}
		System.out.println(Math.min(dp[num][3], Math.min(dp[num][1], dp[num][2])));
	}
}