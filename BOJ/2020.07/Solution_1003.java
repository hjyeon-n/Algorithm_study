import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1003 {	
	static int zero[];
	static int one[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int loop = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < loop; i++) {
			int num = Integer.parseInt(br.readLine());
			int memo[] = new int[num + 1];
			zero = new int[num + 1];
			one = new int[num + 1];
			
			for (int j = 0; j < memo.length; j++) {
				memo[j] = -1;
				zero[j] = 0;
				one[j] = 0;
			}
			
			fib(num, memo);
			System.out.println(zero[num] + " " + one[num]);
		}
	}
	
	public static int fib(int n, int[] memo) {
		if (n == 0) {
			zero[0] = 1;
			one[0] = 0;
			return n;
		}
		if (n == 1) {
			zero[1] = 0;
			one[1] = 1;
			return 1;
		}
		else if (memo[n] > -1) {
			return memo[n];
		}
		else {
			memo[n] = fib(n - 2, memo) + fib(n - 1, memo);
			zero[n] = zero[n - 2] + zero[n - 1];
			one[n] = one[n - 2] + one[n - 1];
			return memo[n];
		}
	}
}