import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Solution_11053 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		int arr[] = new int[num + 1];
		int dp[] = new int[num + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= num; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1] = 1;
		for (int i = 2; i <= num; i++) {
			dp[i] = 1;
			for (int j = 1; j < i; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		Arrays.sort(dp);
		System.out.println(dp[num]);
	}
}