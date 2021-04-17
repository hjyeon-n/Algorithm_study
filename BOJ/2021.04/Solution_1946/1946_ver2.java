import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] grade = new int[N + 1];

			for (int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				grade[x] = y;
			}

			int answer = 1;
			int compare = grade[1];
			for (int j = 2; j <= N; j++) {
				if (grade[j] < compare) {
					compare = grade[j];
					answer++;
				}
			}
			
			System.out.println(answer);
		}
	}
}