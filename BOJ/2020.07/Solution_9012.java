import java.util.Scanner;
public class Solution_9012 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Scanner scan = new Scanner(System.in);
				
		int num = scan.nextInt();
		
		for (int i = 0; i < num; i++) {
			String str = scan.next();
						
			if (VPS(str)) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
	}
	
	public static boolean VPS(String str) {
		String[] array_word = str.split("");
		int sum = 0;
		
		for (int j = 0; j < array_word.length; j++) {
			if (array_word[j].equals("(")) {
				sum += 1;
			}
			else {
				if (sum == 0) {
					return false;
				}
				sum -= 1;
			}
		}
		return sum == 0;
	}
}
