import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1158 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty()) {
			int cnt = 1;
			
			while (cnt++ < K) {
				if (!queue.isEmpty()) {
					int tmp = queue.poll();
					queue.add(tmp);
				}
			}
			
			sb.append(queue.poll() + ", ");
		}
		
		String answer = sb.toString().substring(0, sb.toString().length() - 2);
		System.out.println("<" + answer + ">");
	}
}