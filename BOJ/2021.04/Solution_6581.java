import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_6581 {

	static int cnt;
	static String str;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			try {
				st = new StringTokenizer(br.readLine());
				organize();
			} catch (NullPointerException e) {
				System.out.println(sb + "\n");
				System.exit(0);
			}
		}
	}

	private static void organize() {
		while (st.hasMoreElements()) {
			String s = st.nextToken();
			switch (s) {
			case "<br>":
				sb.append("\n");
				cnt = 0;
				break;
			case "<hr>":
				if (cnt > 0) {
					sb.append("\n");
				}

				for (int i = 0; i < 80; i++) {
					sb.append("-");
				}
				sb.append("\n");
				cnt = 0;
				break;
			default:
				if (cnt == 0) {
					sb.append(s);
					cnt = s.length();
				} else if (cnt + s.length() >= 80) {
					sb.append("\n").append(s);
					cnt = s.length();
				} else {
					sb.append(" ").append(s);
					cnt += s.length() + 1;
				}
				break;
			}
		}
	}
}