import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2225 {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n + 1][k + 1];
        
        for (int i = 0; i <= n; i++) {
        	dp[i][0] = 1 % 1000000000;
        	dp[i][1] = 1 % 1000000000;
        }
        
        for (int i = 0; i <= n; i++) {
        	for (int j = 2; j <= k; j++) {
        		for (int m = 0; m <= i; m++) {
        			dp[i][j] += dp[m][j - 1] % 1000000000;
        			dp[i][j] %= 1000000000;
        		}
        	}
        }
        System.out.println(dp[n][k]);
    }
}