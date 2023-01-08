import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_5430 {
	static Deque<String> dq;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < T; i++) {
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String tmp = br.readLine();

			dq = new ArrayDeque<String>();
			if (n != 0) {
				transition(n, tmp);
			}
			sb.append(doSomething(p) + "\n");
		}

		System.out.println(sb.toString());

	}

	public static void transition(int n, String tmp) {
		String str = tmp.substring(1, tmp.length() - 1);
		str.replace(",", " ");
		String[] arr = str.split(",");

		for (String s : arr) {
			dq.add(s);
		}
	}

	public static String doSomething(String p) {
//		정방향
		boolean direction = true;

		for (int i = 0; i < p.length(); i++) {
			char ch = p.charAt(i);

			if (ch == 'R') {
				// 문자열 뒤집기
				direction = !direction;
			} else {
				if (dq.isEmpty()) {
					return "error";
				}

				// 첫 번째 수 버리기
				if (direction) {
					dq.pollFirst();
				} else {
					dq.pollLast();
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append("[");
		while (!dq.isEmpty()) {
			if (direction) {
				sb.append(dq.pollFirst());
			} else {
				sb.append(dq.pollLast());
			}

			if (dq.size() > 0) {
				sb.append(",");
			}
		}
		sb.append("]");
		return sb.toString();
	}
}