import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Solution_12904 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String T = br.readLine();
		
		String str = T;
		while (true) {
			if (str.length() == S.length()) {
				if (str.equals(S)) {
					System.out.println("1");
				}
				else {
					System.out.println("0");
				}
				break;
			}
			
			if (str.charAt(str.length() - 1) == 'A') {
				str = str.substring(0, str.length() - 1);
			}
			else {
				str = str.substring(0, str.length() - 1);
				StringBuffer sb = new StringBuffer();
				sb.append(str);
				str = sb.reverse().toString();
			}
		}
	}
}