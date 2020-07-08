import java.util.Scanner;
public class problem_2163 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		int y = scan.nextInt();
		System.out.println(slice(x, y));
	}
	
	public static int slice (int x, int y) {		
		int[][] dp = new int[x + 1][y + 1];
		
		dp[1][1] = 0;
		
		int i = 2;
		int j = 2;
		
		if (x == 1) {
			while (j <= y) {
				dp[1][j] = dp[1][j - 1] + 1;
				j++;	
			}
		}
		else {
			while (i <= x) {
				while (j <= y) {
					dp[1][j] = dp[1][j - 1] + 1;
					j++;	
				}
				
				dp[i][y] = dp[i - 1][y] + y;
				i++;
			}
		}
		
		return dp[x][y];
	}
}