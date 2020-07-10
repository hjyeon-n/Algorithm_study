import java.util.Scanner;
public class 11726_top-down {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Scanner scan = new Scanner(System.in);
				
		int num = scan.nextInt();
		int[] memo = new int[num + 1];
		
		memo[1] = 1;
		
		if (num > 1) {
			memo[2] = 2;
			for (int i = 3; i <= num; i++) {
				memo[i] = -1;
			}
		}
		
		System.out.println(tile(num, memo));
	}
	
	public static int tile(int n, int[] memo) {
		if (n == 1) {
			return 1;
		}
		if(memo[n] != -1) {
			return memo[n];
		}
		else {
			memo[n] = (tile(n - 1, memo) + tile(n - 2, memo)) % 10007; 
			return memo[n];
		}
	}
}
