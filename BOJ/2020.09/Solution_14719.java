import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Solution_14719 {    
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[W];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[W];
		int max = -1;
		for (int i = 0; i < W; i++) {
			max = Math.max(arr[i], max);
			dp[i] = max;
		}
		
		int[] dp_r = new int[W];
		int max_r = -1;
		for (int i = W - 1; i >= 0; i--) {
			max_r = Math.max(arr[i], max_r);
			dp_r[i] = max_r;
		}
		
		int sum = 0;
		for (int i = 0; i < W; i++) {
			int h = Math.min(dp[i], dp_r[i]);
			sum += h - arr[i];
		}
		
		System.out.println(sum);
	}
}
