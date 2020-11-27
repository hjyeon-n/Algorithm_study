import java.util.Stack;

public class Programmers {
	public static void main(String[] args) {
    	// TODO Auto-generated method stub
		System.out.println(solution("baabaa"));
    }
    
	public static int solution(String s)
    {
        Stack<Character> stack = new Stack<Character>();
        stack.push(s.charAt(0));
        
        for (int i = 1; i < s.length(); i++) {
        	char alpha = s.charAt(i);
        	
        	if (!stack.isEmpty() && stack.peek() == alpha) {
        		stack.pop();
        	}
        	else {
        		stack.push(alpha);
        	}	
        }
        
        if (stack.isEmpty()) {
        	return 1;
        }
        return 0;
    }
}