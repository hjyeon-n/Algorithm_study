import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[][] candidate = new int[N][2];

			for (int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				candidate[j][0] = Integer.parseInt(st.nextToken());
				candidate[j][1] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(candidate, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub

					if (o1[0] < o2[0]) {
						return -1;
					}
					else if (o1[0] > o2[0]) {
						return 1;
					}
					return 0;
				}
			});
			
			int answer = 1;
			int max_x = candidate[0][0];
			int max_y = candidate[0][1];
			for (int j = 1; j < N; j++) {
				if (candidate[j][1] < max_y || candidate[j][0] < max_x ) {
					max_x = candidate[j][0];
					max_y = candidate[j][1];
					answer++;
				}
			}
			
			System.out.println(answer);
		}
	}
}