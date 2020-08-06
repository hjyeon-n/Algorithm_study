import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Solution_11055 {

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
		
		dp[0] = 0;
		for (int i = 1; i <= num; i++) {
			dp[i] = arr[i];
			for (int j = 1; j < i; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[j] + arr[i], dp[i]);
				}
			}
		}
		Arrays.sort(dp);
		System.out.println(dp[num]);
	}
}