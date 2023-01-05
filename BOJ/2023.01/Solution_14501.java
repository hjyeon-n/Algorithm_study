import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_14501 {
	static int N;
	static int[] arr_t;
	static int[] arr_p;
	static int max;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		arr_t = new int[N + 1];
		arr_p = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			arr_t[i] = Integer.parseInt(st.nextToken());
			arr_p[i] = Integer.parseInt(st.nextToken());
		}

		int sum = 0;
		max = 0;
		for (int i = 1; i <= N; i++) {
			sum = 0;
//			만약 1일 차에 걸리는 상담 시간이 3일이라면 4일 이후부터 상담이 가능 하기 때문
//			N + 1인 이유는 당일에 끝낼 수 있는 상담도 1일로 측정되기 때문
			if (i + arr_t[i] <= N + 1) {
				sum = arr_p[i];
				dfs(i, sum);
			}
		}

		System.out.println(max);
	}

	public static void dfs(int idx, int sum) {
//		이미 N + 1일이 넘거나 같으면 더이상 상담을 진행할 수 없기 때문에 base condition이 됨
		if (idx + arr_t[idx] >= N + 1) {
			max = Math.max(sum, max);
			return;
		}
		
//		여러 경우의 수를 구하기 위해 재귀를 사용했으며, 항상 모든 경우의 시작일은 전에 상담했던 날 + 걸리는 시간
//		이때, i는 반복인자이기 때문에 N까지만 고려
		for (int i = idx + arr_t[idx]; i <= N; i++) {
//			상담은 퇴사날까지 진행할 수 있음
			if (i + arr_t[i] <= N + 1) {
				sum += arr_p[i];
				dfs(i, sum);
				sum -= arr_p[i];
			} else {
				dfs(i, sum);
			}
		}
	}
}