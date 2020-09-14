import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
public class Solution_1038 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		if (num <= 9) {
			System.out.println(num);
			return;
		}
		
		if (num > 1022) {
			System.out.println("-1");
			return;
		}
		
		Queue<Long> queue = new LinkedList<Long>();
		int cnt = 0;
		for (long i = 1; i <= 9; i++) {
			queue.add(i);
			cnt++;
		}
		
		while(!queue.isEmpty()) {
			long x = queue.poll();
			long tmp = x % 10;
			for (int i = 0; i < tmp; i++) {
				queue.add(x * 10 + i);
				cnt++;
				
				if (cnt == num) {
					System.out.println(x * 10 + i);
					return;
				}
			}
		}
	}
}