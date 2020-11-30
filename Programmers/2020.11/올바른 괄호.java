import java.util.Stack;
public class Programmers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("()()"));
	}

	public static boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<Character>();
        
        if (s.charAt(0) == '(') {
            stack.push(s.charAt(0));
        }
        else {
            return false;
        }
        
        for (int i = 1; i < s.length(); i++) {
            char alpha = s.charAt(i);
            if (alpha == '(') {
                stack.push(alpha);
            }
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                
                if (stack.peek() == '(') {
                    stack.pop();
                }
                else {
                    return false;
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }
        
        return answer;
    }
}