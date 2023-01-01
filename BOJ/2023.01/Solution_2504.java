import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_2504 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len = str.length();
		int sum = 0;

		Stack<String> stack = new Stack<>();

		boolean check = true;
		for (int i = 0; i < len; i++) {
			
			if (!check) {
				System.out.println("0");
				return;
			}
			
			String alpha = String.valueOf(str.charAt(i));

			if (alpha.equals("(") || alpha.equals("[")) {
				stack.push(alpha);
			} 
			else {
				if (stack.isEmpty()) {
					System.out.println("0");
					return;
				}

				if (alpha.equals(")")) {
					if (stack.peek().equals("(")) {
						stack.pop();
						stack.push("2");
					} 
					else {
						check = stackInnerLoop(stack, alpha);
					}
				} 
				else {
					if (stack.peek().equals("[")) {
						stack.pop();
						stack.push("3");
					} 
					else {
						check = stackInnerLoop(stack, alpha);
					}
				}
			}
		}

		while (!stack.isEmpty()) {
			String peek = stack.peek();
			if (peek.equals("(") || peek.equals(")") || peek.equals("[")
					|| peek.equals("]")) {
				System.out.println("0");
				return;
			}
			sum += Integer.parseInt(stack.pop());
		}
		
		System.out.println(sum);
	}

	public static boolean stackInnerLoop(Stack<String> stack, String alpha) {
		int result = 0;
		String good = "";
		String bad = "";
		boolean flag = false;
		int num = 0;
		
		if (alpha.equals(")")) {
			good = "(";
			bad = "[";
			num = 2;
		}
		else {
			good = "[";
			bad = "(";
			num = 3;
		}

		while (!stack.isEmpty()) {
			String top = stack.peek();

			if (top.equals(bad)) {
				return false;
			} 
			else if (top.equals(good)) {
				stack.pop();
				result *= num;
				stack.push(String.valueOf(result));
				flag = true;
				break;
			} 
			else {
				result += Integer.parseInt(stack.pop());
			}
		}
		
		if (stack.isEmpty() && !flag) {
			return false;
		}
		
		return true;
	}
}