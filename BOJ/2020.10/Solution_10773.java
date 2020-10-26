import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
public class Solution_10773 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for (int i = 0; i < K; i++) {
			int n = Integer.parseInt(br.readLine());
			
			if (n == 0) {
				stack.pop();
			}
			else {
				stack.push(n);
			}
		}
		
		int sum = 0;
		int size = stack.size();
		for (int i = 0; i < size; i++) {
			sum += stack.pop();
		}
		
		System.out.println(sum);
	}
}