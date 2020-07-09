import java.util.Arrays;
import java.util.Scanner;
public class Solution_11053 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		int arr[] = new int[num + 1];
		int dp[] = new int[num + 1];
		
		for (int i = 1; i <= num; i++) {
			arr[i] = scan.nextInt();
		}
		
		for (int i = 1; i <= num; i++) {
			dp[i] = 1;
			for (int j = 1; j <= i; j++) {
				if (arr[i] > arr[j] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		Arrays.sort(dp);
		System.out.println(dp[num]);
	}
}