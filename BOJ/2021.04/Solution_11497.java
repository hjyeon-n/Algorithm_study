import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_11497 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int[] newArr = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			newArr[0] = arr[0];
			
			int idx = 1;
			for (int j = 1; j < N / 2; j++) {
				newArr[j] = arr[idx++];
				newArr[N - j] = arr[idx++];
			}
			
			if (N % 2 == 0) {
				newArr[N / 2] = arr[N - 1];
			}
			else {
				newArr[N / 2] = arr[N - 2];
				newArr[N / 2 + 1] = arr[N - 1];
			}
			
			int max = newArr[N - 1] - newArr[0];
			for (int j = 1; j < N; j++) {
				max = Math.max(max, Math.abs(newArr[j] - newArr[j - 1]));
			}
			
			System.out.println(max);
		}
	}
}