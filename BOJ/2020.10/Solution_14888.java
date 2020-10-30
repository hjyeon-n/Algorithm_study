import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Solution_14888 {
	static int min, max;
	static int N;
	static int[] numArr;
	static int[] calc;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		numArr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
		
		calc = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			calc[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(calc[0], calc[1], calc[2], calc[3], 1, numArr[0]);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void dfs(int plus, int minus, int multiply, int divide, int cnt, int sum) {
		if (cnt == N) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
		}
		
		if (plus > 0) {
			dfs(plus - 1, minus, multiply, divide, cnt + 1, sum + numArr[cnt]);
		}
		
		if (minus > 0) {
			dfs(plus, minus - 1, multiply, divide, cnt + 1, sum - numArr[cnt]);
		}
		
		if (multiply > 0) {
			dfs(plus, minus, multiply - 1, divide, cnt + 1, sum * numArr[cnt]);
		}
		
		if (divide > 0) {
			dfs(plus, minus, multiply, divide - 1, cnt + 1, sum / numArr[cnt]);
		}
	}
}