import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Solution_2156 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		int arr[] = new int[num + 1];
		int dp[] = new int[num + 1];
		
		for (int i = 1; i <= num; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
	
		dp[0] = 0;
		dp[1] = arr[1];
		
		if (num >= 2) {
			dp[2] = dp[1] + arr[2];
		}
		for (int i = 3; i <= num; i++) {
			dp[i] = Math.max(dp[i - 1], arr[i] + Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]));
        }
		Arrays.sort(dp);
		System.out.println(dp[num]);
	}
}