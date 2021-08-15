import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Solution_2164 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Deque<Integer> dq = new LinkedList<Integer>();
		
		for (int i = 1; i <= N; i++) {
			dq.add(i);
		}
		
		while (dq.size() >= 2) {
			dq.pollFirst();
			int tmp1 = dq.pollFirst();			
			dq.addLast(tmp1);
		}
		
		System.out.println(dq.poll());
	}
}