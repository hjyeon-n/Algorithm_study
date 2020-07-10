import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Solution_9465 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int loop = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < loop; i++) {
			int n = Integer.parseInt(br.readLine());
			
			long[][] arr = new long[2][n + 1];
			
			for (int j = 0; j < 2; j++) {
				int k = 1;
				
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				
				while(st.hasMoreTokens()){
					arr[j][k++] = Integer.parseInt(st.nextToken());
				}
			}
			
			long[][] dp = new long[n + 1][3];
			
            dp[1][0] = 0; 
            dp[1][1] = arr[0][1];
            dp[1][2] = arr[1][1]; 
            
            for(int j = 2; j <= n; j++) {
                dp[j][0] = Math.max(dp[j - 1][0], Math.max(dp[j - 1][1], dp[j - 1][2]));
                dp[j][1] = Math.max(dp[j - 1][0], dp[j - 1][2]) + arr[0][j];
                dp[j][2] = Math.max(dp[j - 1][0], dp[j - 1][1]) + arr[1][j];
            }
                    
            System.out.println(Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2])));
		}		
	}
}