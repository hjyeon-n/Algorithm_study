import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Solution_3613 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		if (str.charAt(0) == '_' || str.charAt(str.length() - 1) == '_' 
				|| Character.isUpperCase(str.charAt(0))) {
			System.out.println("Error!");
			return;
		}

		String answer = "";

		//		C++일 때 JAVA로
		if (str.contains("_")) {
			boolean flag = true;

			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '_') {
					if (!flag) {
						System.out.println("Error!");
						return;
					}
					flag = false;
				}
				else {
					if (Character.isUpperCase(str.charAt(i))) {
						System.out.println("Error!");
						return;
					}

					if (flag) {
						answer += String.valueOf(str.charAt(i));
					}
					else {
						answer += String.valueOf(str.charAt(i)).toUpperCase();
						flag = true;
					}
				}
			}
		}
//		JAVA에서 C++로
		else {
			for (int i = 0; i < str.length(); i++) {
				if (Character.isLowerCase(str.charAt(i))) {
					answer += String.valueOf(str.charAt(i));
				}
				else {
					answer += "_" + String.valueOf(str.charAt(i)).toLowerCase();
				}
			}
		}
		
		System.out.println(answer);
	}
}