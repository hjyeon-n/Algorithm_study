import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class 14889_ver1 {
	static int[] arrA;
	static int[] tmp;
	static int min;
	static boolean[] visited;
	static int sum;
	static int map[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		min = Integer.MAX_VALUE;
		
		int n = Integer.parseInt(st.nextToken());
		int m = n / 2;
		
		map = new int[n + 1][n + 1];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		arrA = new int[n];
		comb(n, m, 0, 0);
		System.out.println(min);
	}
	
	private static void comb(int n, int m, int depth, int idx) {
		if (depth == m && arrA[0] == 1) {
			int[] arrB = new int[m];
			int k = 0;
			for (int i = 1; i <= n; i++) {
				int flag = 0;
				for (int j = 0; j < m; j++) {
					if (arrA[j] == i) {
						flag = 1;
					}
				}
				if (flag == 0) {
					arrB[k++] = i;
				}
			}
			
			sum = 0;
			visited = new boolean[n];
			tmp = new int[n];
			permutation(m, 2, 0, arrA);
			int sumA = sum / 2;
			sum = 0;
			visited = new boolean[n];
			tmp = new int[n];
			permutation(m, 2, 0, arrB);
			int sumB = sum / 2;
			
			min = Math.min(min, Math.abs(sumA - sumB));
			
			return;
		}
	 
		for (int i = idx; i < n; i++) {
			arrA[depth] = i + 1;	
			comb(n, m, depth + 1, i + 1);
		}
	}
	
	private static void permutation(int n, int m, int depth, int[] arr) {
		if (depth == m) {
			sum += map[arr[tmp[0] - 1]][arr[tmp[1] - 1]] + map[arr[tmp[1] - 1]][arr[tmp[0] - 1]];
			return;
		}
	 
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;	
				tmp[depth] = i + 1;	
				permutation(n, m, depth + 1, arr);	
				visited[i] = false;
			}
		}
	}
}