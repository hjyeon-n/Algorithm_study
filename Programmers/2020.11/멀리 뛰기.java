public class Programmers {
	public static void main(String[] args) {
    	// TODO Auto-generated method stub
    	System.out.print(solution(4));
    }
    
	public static long solution(int n) {
        long[] dp = new long[n + 1];
        
        if (n <= 2) {
            return n;
        }
        
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }
        return dp[n];
    }
}