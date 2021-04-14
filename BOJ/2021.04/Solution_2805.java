import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2805 {
	static long[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new long[N];
		
		st = new StringTokenizer(br.readLine());
		long max = -1;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		
		long answer = setHeight(M, max);
		System.out.println(answer);
	}
	
	public static long setHeight(int M, long max) {
		long s = 0;
		long e = max;
		long answer = 0;
		
		while (s < e) {
			long mid = (s + e) / 2;
			long rslt = cal(mid);
			
			if (rslt > M) {
				answer = mid;
				s = mid + 1;
			}
			else if (rslt < M) {
				e = mid;
			}
			else {
				return mid;
			}
		}
		
		return answer;
	}
	
	public static long cal(long val) {
		long sum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > val) {
				sum += arr[i] - val;
			}
		}
		
		return sum;
	}
}