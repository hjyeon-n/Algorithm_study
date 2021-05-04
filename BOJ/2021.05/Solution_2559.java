import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2559 {
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int s = 0;
		int e = s + K - 1;
		
		int sum = 0;
		
		for (int i = s; i <= e; i++) {
			sum += arr[i];
		}
		int max = sum;
		
		while (e < N - 1) {
			sum -= arr[s];
			s++;
			e++;
			sum += arr[e];
			
			max = Math.max(max, sum);
		}
		
		System.out.println(max);
	}
}