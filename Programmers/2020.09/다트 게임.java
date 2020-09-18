import java.util.Stack;

public class Programmers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("1S*2T*3S"));
	}

	public static int solution(String dartResult) {
        int n = -1;
        int a, b;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < dartResult.length(); i++) {
        	switch(dartResult.charAt(i)) {
        	case 'S':
        		stack.push((int)(Math.pow(n, 1)));
        		n = -1;
        		break;
        	case 'D':
        		stack.push((int)(Math.pow(n, 2)));
        		n = -1;
        		break;
        	case 'T':
        		stack.push((int)(Math.pow(n, 3)));
        		n = -1;
        		break;
        	case '*':
        		a = stack.pop();
        		if (!stack.isEmpty()) {
        			b = stack.pop();
        			stack.push(b * 2);
        		}
        		stack.push(a * 2);
        		break;
        	case '#':
        		a = stack.pop();
        		stack.push(a * -1);
        		break;
        	default:
        		if (n != -1) {
        			n = 10;
        		}
        		else {
        			String str = String.valueOf(dartResult.charAt(i));
        			n = Integer.parseInt(str);
        		}
        		break;
        	}
        }

        int sum = 0;
        while(!stack.isEmpty()) {
        	sum += stack.pop();
        }
        return sum;
    }
}
