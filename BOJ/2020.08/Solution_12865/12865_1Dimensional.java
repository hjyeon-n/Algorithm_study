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
		int[] dp = new int[K + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			arr_w[i] = Integer.parseInt(str.nextToken());
			arr_v[i] = Integer.parseInt(str.nextToken());
		}
		
		for(int i = 1; i <= N; i++) {
		    for(int j = K; j - arr_w[i] >= 0; j--) {
		        dp[j] = Math.max(dp[j], dp[j -arr_w[i]] + arr_v[i]);
		    }
		}
		System.out.println(dp[K]);
	}
}