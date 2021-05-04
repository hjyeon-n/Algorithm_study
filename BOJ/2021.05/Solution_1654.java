import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1654 {
	static int K, N, answer;
	static int[] arr;
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[K];
		
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		long s = 1;
		long e = arr[K - 1];
		answer = 0;
		
		System.out.println(binarySearch(s, e));
	}
	
	public static long binarySearch(long s, long e) {
		while (s <= e) {
			long cnt = 0;
			long mid = (s + e) / 2;
			
			for (int i = 0; i < K; i++) {
				cnt += arr[i] / mid;
			}
			
			if (cnt < N) {
				e = mid - 1;
			}
			else if (cnt >= N){
				s = mid + 1;
			}
		}
		
		return e;
	}
}