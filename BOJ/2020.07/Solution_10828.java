import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	String instruction = st.nextToken();
        	int number = 0;
        	if (instruction.equals("push")) {
        		number = Integer.parseInt(st.nextToken());
        	}
            int output = -1;
            
            switch (instruction) {
                case "push":
                    stack.push(number);
                    break;
                case "pop":
                    if (stack.isEmpty()) {
                    	output = -1;
                    }
                    else {
                    	output = stack.pop();
                    }
                    break;
                case "size":
                    output = stack.size();
                    break;
                case "empty":
                	if (stack.isEmpty()) {
                		output = 1;
                	}
                	else {
                		output = 0;
                	}
                    break;
                case "top":
                    if (stack.isEmpty()) {
                        output = -1;
                    }
                    else {
                    	output = stack.peek();
                    }
                    break;
            }
            if (!instruction.equals("push")) {
        		System.out.println(output);
        	}
        }
    }
}
