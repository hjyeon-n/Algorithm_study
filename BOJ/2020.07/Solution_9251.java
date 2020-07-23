import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Solution_9251 {

	public static int[][] c;
	public static char[] x;
	public static char[] y;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		x = new char[1002];
		y = new char[1002];
		c = new int[1002][1002];

		String str_x = br.readLine();
		String str_y = br.readLine();
		
		for (int i = 1; i <= str_x.length(); i++) {
			x[i] = str_x.charAt(i - 1);
		}
		
		for (int i = 1; i <= str_y.length(); i++) {
			y[i] = str_y.charAt(i - 1);
		}

		System.out.println(lcs(str_x.length(), str_y.length()));
	}
	
	public static int lcs(int m, int n) /* m: length of X, n: length of Y */
	{
		for (int i = 0; i <= m; i++) {
			c[i][0] = 0;
		}
		for (int j = 0; j <= n; j++) {
			c[0][j] = 0;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++ ) {
				if (x[i] == y[j]) {
					c[i][j] = c[i - 1][j - 1] + 1;
				}
				else {
					c[i][j] = Math.max(c[i - 1][j], c[i][j - 1]);
				}
			}
		}
		return c[m][n];
	}
}