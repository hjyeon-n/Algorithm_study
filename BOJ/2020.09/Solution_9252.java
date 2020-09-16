import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Solution_9252 {
	public static int[][] c;
	public static char[] x;
	public static char[] y;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str_x = br.readLine();
		String str_y = br.readLine();
		
		x = new char[str_x.length() + 1];
		y = new char[str_y.length() + 1];
		c = new int[str_x.length() + 1][str_y.length() + 1];
		
		for (int i = 1; i <= str_x.length(); i++) {
			x[i] = str_x.charAt(i - 1);
		}
		
		for (int i = 1; i <= str_y.length(); i++) {
			y[i] = str_y.charAt(i - 1);
		}

		int len = lcs(str_x.length(), str_y.length());
		System.out.println(len);
		System.out.println(backTracking(len, str_x.length(), str_y.length()));
	}
	
	public static int lcs(int m, int n) {
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
	
	public static String backTracking(int length, int m, int n) {
		String str = "";
		int len = length;
		
		for (int i = m; i >= 0; i--) {
			for (int j = n; j >= 0; j--) {
				if (x[i] == y[j] && len == c[i][j]) {
					str += x[i];
					len--;
					break;
				}
			}
		}
		return new StringBuffer(str.trim()).reverse().toString();
	}
}