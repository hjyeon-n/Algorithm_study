import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1769 {
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String X = br.readLine();
		isMultiple(X, 0);
	}
	
	public static void isMultiple(String X, int cnt) {
		if (X.length() == 1) {
			System.out.println(cnt);
			if (Integer.parseInt(X) % 3 == 0) {
				System.out.println("YES");
				return;
			}
			System.out.println("NO");
			return;
		}
		
		int sum = 0;
		for (int i = 0; i < X.length(); i++) {
			sum += X.charAt(i) - '0';
		}
		
		isMultiple(String.valueOf(sum), cnt + 1);
	}
}
