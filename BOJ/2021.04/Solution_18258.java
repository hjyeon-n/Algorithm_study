import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Solution_18258 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new LinkedList<Integer>();
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			String[] arr = str.split(" ");
			
			if (arr[0].equals("push")) {
				deque.add(Integer.parseInt(arr[1]));
			}
			else if (arr[0].equals("pop")) {
				if (deque.isEmpty()) {
					sb.append("-1\n");
				}
				else {
					sb.append(deque.poll() + "\n");
				}
			}
			else if (arr[0].equals("size")) {
				sb.append(deque.size() + "\n");
			}
			else if (arr[0].equals("empty")) {
				if (deque.isEmpty()) {
					sb.append("1\n");
				}
				else {
					sb.append("0\n");
				}
			}
			else if (arr[0].equals("front")) {
				if (deque.isEmpty()) {
					sb.append("-1\n");
				}
				else {
					sb.append(deque.peek() + "\n");
				}
			}
			else {
				if (deque.isEmpty()) {
					sb.append("-1\n");
				}
				else {
					sb.append(deque.getLast() + "\n");
				}
			}
		}
		
		System.out.println(sb.toString());
	}
}