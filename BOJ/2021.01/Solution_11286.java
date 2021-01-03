import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_11286 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					if (Math.abs(o1) > Math.abs(o2) || (Math.abs(o1) == Math.abs(o2) && o1 > o2)) {
						return 1;
					}
					return -1;
				}
			}
		);
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if (num == 0) {
				if (pQueue.isEmpty()) {
					sb.append(0 + "\n");
				}
				else {
					sb.append(pQueue.poll() + "\n");
				}
			}
			else {
				pQueue.offer(num);
			}
		}
		System.out.println(sb.toString());
	}
}