import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
public class Solution_10866 {    
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int loop = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new LinkedList<Integer>();
		
		for (int i = 0; i < loop; i++) {
			String[] arr = br.readLine().split(" ");
			
			int num = 0;
			if (arr.length == 2) {
				num = Integer.parseInt(arr[1]);
			}
			
			switch(arr[0]) {
			case "push_front":
				deque.addFirst(num);
				break;
				
			case "push_back":
				deque.addLast(num);
				break;
				
			case "pop_front":
				if (deque.isEmpty()) {
					System.out.println("-1");
				}
				else {
					System.out.println(deque.pollFirst());
				}
				break;
				
			case "pop_back":
				if (deque.isEmpty()) {
					System.out.println("-1");
				}
				else {
					System.out.println(deque.pollLast());
				}
				break;
				
			case "size":
				System.out.println(deque.size());
				break;
				
			case "empty":
				if (deque.isEmpty()) {
					System.out.println("1");
				}
				else {
					System.out.println("0");
				}
				break;
				
			case "front":
				if (deque.isEmpty()) {
					System.out.println("-1");
				}
				else {
					System.out.println(deque.peekFirst());
				}
				break;
			
			case "back":
				if (deque.isEmpty()) {
					System.out.println("-1");
				}
				else {
					System.out.println(deque.peekLast());
				}
				break;
			}
		}
	}
}