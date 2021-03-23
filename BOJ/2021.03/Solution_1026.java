import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Solution_1026 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] A = new int[N];
		int[] B = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		int[] sorted = new int[N];
		boolean[] visited = new boolean[N];
		
		int idx = 0;
		while (true) {
			if (check(visited)) {
				break;
			}
			
			int max = -1;
			int max_idx = -1;
			for (int i = 0; i < N; i++) {
				if (!visited[i] && max < B[i]) {
					max = B[i];
					max_idx = i;
				}
			}
			
			visited[max_idx] = true;
			sorted[max_idx] = A[idx++];
		}
		
		int answer = 0;
		for (int i = 0; i < N; i++) {
			answer += sorted[i] * B[i];
		}
		
		System.out.println(answer);
	}
	
	public static boolean check(boolean[] visited) {
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				return false;
			}
		}
		return true;
	}
}