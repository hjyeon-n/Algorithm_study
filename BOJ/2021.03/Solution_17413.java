import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_17413 {
    public static void main(String[] args) throws IOException{
    	// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        
        String[] arr = S.split(" ");
        boolean flag = true;
        StringBuilder answer = new StringBuilder();
        
        for (int i = 0; i < arr.length; i++) {
        	String str = arr[i];
        	Stack<Character> stack = new Stack<Character>();
        	StringBuilder tmp = new StringBuilder();
        	int idx = 0;
        	
        	for (int j = 0; j < str.length(); j++) {
        		char alpha = str.charAt(j);
        		
        		if (alpha == '<') {
        			if (!stack.isEmpty()) {
	        			StringBuilder stackStr = new StringBuilder();
	                	while (!stack.isEmpty()) {
	                		stackStr.append(stack.pop());
	                	}
	                	answer.append(stackStr);
        			}
        			idx = j;
        			flag = false;
        		}
        		
        		if (flag) {
        			stack.add(alpha);
        		}
        		else {
        			tmp.append(alpha);
        		}
        		
        		if (alpha == '>') {
        			if (stack.isEmpty()) {
        				answer.append(tmp);
        				tmp = new StringBuilder();
        			}
        			flag = true;
        		}
        	}
        	
        	
        	StringBuilder stackStr = new StringBuilder();
        	while (!stack.isEmpty()) {
        		stackStr.append(stack.pop());
        	}
        	
        	if (idx == 0) {
        		answer.append(tmp.append(stackStr + " "));
        	}
        	else {
        		answer.append(stackStr.append(tmp + " "));
        	}
        }
        
        System.out.println(answer.toString());
    }
}