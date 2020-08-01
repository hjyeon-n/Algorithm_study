import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
public class Solution_2565 {
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int arr[][] = new int[n + 1][2];
		int dp[] = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] start, int[] end) {
				if(start[0] < end[0]){
					return -1;
				}
				else if (start[0] > end[0]) {
					return 1;
				}
				return 0;
			}
		});

		for (int i = 1; i <= n; i++) {
			dp[i] = 1;
			for (int j = 1; j <= i; j++) {
				if (arr[i][1] > arr[j][1] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		Arrays.sort(dp);
		System.out.println(n - dp[n]);
	}
}