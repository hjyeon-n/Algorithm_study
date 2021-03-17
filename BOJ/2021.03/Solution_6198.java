import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
public class Solution_6198 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Stack<Long> stack = new Stack<Long>();
		long cnt = 0;
		for (int i = 0; i < N; i++) {
			Long h = Long.parseLong(br.readLine());
			
			while (!stack.isEmpty()) {
				if (stack.peek() <= h) {
					stack.pop();
				}
				else {
					break;
				}
			}
			
			cnt += stack.size();
			stack.push(h);
		}
		
		System.out.println(cnt);
	}
}