import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1080 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] A = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				A[i][j] = str.charAt(j) - '0';
			}
		}
		
		int[][] B = new int[N][M];
		for (int i = N; i < 2 * N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				B[i - N][j] = str.charAt(j) - '0';
			}
		}
		
		int cnt = 0;
		for (int i = 0; i < N - 2; i++) {
			for (int j = 0; j < M - 2; j++) {
				if (A[i][j] == B[i][j]) {
					continue;
				}
				
				cnt++;
				
				for (int x = i; x < i + 3; x++) {
					for (int y = j; y < j + 3; y++) {
						A[x][y] ^= 1;
					}
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (A[i][j] != B[i][j]) {
					System.out.println("-1");
					return;
				}
			}
		}
		
		System.out.println(cnt);
	}
}