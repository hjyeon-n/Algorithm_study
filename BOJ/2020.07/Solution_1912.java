import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {

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
		dp[0] = -1001;
		dp[1] = arr[1];
		for (int i = 2; i <= num; i++) {
			dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
        }
		Arrays.sort(dp);
		System.out.println(dp[num]);
	}
}