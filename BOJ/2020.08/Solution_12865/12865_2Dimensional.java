import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr_w = new int[N + 1];
		int[] arr_v = new int[N + 1];
		int[][] dp = new int[N + 1][K + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			arr_w[i] = Integer.parseInt(str.nextToken());
			arr_v[i] = Integer.parseInt(str.nextToken());
		}
		
		for(int i = 1; i <= N;i++) {
			for(int j = 1; j <= K; j++) {
				dp[i][j] = dp[i - 1][j];
				if(j - arr_w[i] >= 0) { 
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - arr_w[i]] + arr_v[i]);
				}
			}
		}
		
		System.out.println(dp[N][K]);
	}
}