import java.util.*;

public class 17413_ver2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Stack<Character> stack = new Stack<Character>();
		boolean flag = true;
		String input = sc.nextLine();
		StringBuilder result = new StringBuilder();
		
		for (char ch : input.toCharArray()) {
			if (ch == '<') {
				flag = false; 
				
				while (!stack.isEmpty()) {
					result.append(stack.pop());
				}
				result.append("<");
			} else if (ch == '>') {
				flag = true;
				result.append(">");
			} else if(ch == ' ') { 
				while(!stack.isEmpty()) {
					result.append(stack.pop());
				}
				result.append(" ");
			} else {
				if(flag) {
					stack.push(ch);
				}
				else {
					result.append(ch);
				}
			}
		}
		
		while(!stack.isEmpty()) {
			result.append(stack.pop());
		}
		
		System.out.println(result);
		sc.close();
	}
}