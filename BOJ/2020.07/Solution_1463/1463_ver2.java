import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class 1463_ver2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] dp = new int[num + 1];
		
		dp[0] = 0;
        dp[1] = 0;
        
        for(int i = 2; i <= num; i++) {
            dp[i] = dp[i - 1] + 1;
            if(i % 2 == 0) {
            	dp[i] = Math.min(dp[i / 2] + 1, dp[i]); 
            }
            if(i % 3 == 0) {
            	dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
            }
        }
        System.out.println(dp[num]);
	}
}