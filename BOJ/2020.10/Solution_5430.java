import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_5430 {
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			String command = br.readLine();
			int cnt = Integer.parseInt(br.readLine());
			String strArr = br.readLine();
			boolean flag = false;
			
			strArr = strArr.substring(1, strArr.length() - 1);
			String[] arr = strArr.split(",");
			int direction = 0; 
			
			Deque<String> deque = new ArrayDeque<String>();
			for (int j = 0; j < arr.length; j++) {
				deque.add(arr[j]);
			}
			
			for (int j = 0; j < command.length(); j++) {
				char ch = command.charAt(j);

				if (ch == 'R') {
					if (direction == 0) {
						direction = 1;
					}
					else {
						direction = 0;
					}
				}
				else {
					if (cnt == 0) {
						flag = true;
						break;
					}
					else {
						if (direction == 0) {
							deque.pollFirst();
						}
						else {
							deque.pollLast();
						}
						cnt--;
					}
				}
			}
			
			if (flag) {
				System.out.println("error");
			}
			else {
				StringBuilder answer = new StringBuilder("[");
				while (deque.size() > 1) {
					if (direction == 0) {
						answer.append(deque.pollFirst() + ",");
					}
					else {
						answer.append(deque.pollLast() + ",");
					}
				}
				
				if (!deque.isEmpty()) {
					answer.append(deque.poll());
				}
				answer.append("]");
				System.out.println(answer);
			}
		}
	}
}