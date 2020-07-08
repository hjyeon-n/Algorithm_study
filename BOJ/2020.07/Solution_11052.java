import java.util.Scanner;
public class Solution_11052 {

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
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + arr[j]);
            }
        }
		System.out.println(dp[num]);
	}
}