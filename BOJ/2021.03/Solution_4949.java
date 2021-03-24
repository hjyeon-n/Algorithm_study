import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
public class Solution_4949 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String str = br.readLine();
			if (str.equals(".")) {
				break;
			}
			
			str = str.replace(" ", "");
			Stack<Character> stack = new Stack<Character>();
			
			boolean flag = true;
			for (int i = 0; i < str.length(); i++) {
				char alpha = str.charAt(i);
				if (alpha == '(') {
					stack.add(alpha);
				}
				else if (alpha == ')') {
					if (stack.size() == 0) {
						flag = false;
						break;
					}
					else {
						if (stack.peek() == '(') {
							stack.pop();
						}
						else {
							break;
						}
					}
				}
				else if (alpha == '[') {
					stack.add(alpha);
				}
				else if (alpha == ']') {
					if (stack.size() == 0) {
						flag = false;
						break;
					}
					else {
						if (stack.peek() == '[') {
							stack.pop();
						}
						else {
							break;
						}
					}
				}
			}
			
			if (stack.isEmpty() && flag) {
				System.out.println("yes");
			}
			else {
				System.out.println("no");
			}
		}
	}
}