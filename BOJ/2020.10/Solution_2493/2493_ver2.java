import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
public class 2493_ver2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] arr = new int[num + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= num; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Point> stack = new Stack<Point>();
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= num; i++) {
			while (true) {
				if (!stack.isEmpty()) {
					Point stackVal = stack.peek();
					if (stackVal.val > arr[i]) {
						stack.push(new Point(arr[i], i));
						sb.append(stackVal.idx + " ");
						break;
					}
					else {
						stack.pop();
					}
				}
				else {
					stack.push(new Point(arr[i], i));
					sb.append(0 + " ");
					break;
				}
			}
		}
		
		System.out.println(sb);
	}
}

class Point {
	int val;
	int idx;
	
	public Point(int val, int idx) {
		this.val = val;
		this.idx = idx;
	}
}