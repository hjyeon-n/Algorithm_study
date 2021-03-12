import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2304 {
	
	static String str;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[1001];
		int len = -1;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			len = Math.max(len, L);
			arr[L] = H;
		}
		
		int[] dp_r = new int[len + 1];
		int[] dp_l = new int[len + 1];
		
		int max_r = -1;
		for (int i = 1; i <= len; i++) {
			max_r = Math.max(max_r, arr[i]);
			dp_r[i] = max_r;
		}
		
		int max_l = -1;
		for (int i = len; i >= 0; i--) {
			max_l = Math.max(max_l, arr[i]);
			dp_l[i] = max_l;
		}
		
		int answer = 0;
		for (int i = 1; i <= len; i++) {
			answer += Math.min(dp_l[i], dp_r[i]);
		}
		
		System.out.println(answer);
	}
}