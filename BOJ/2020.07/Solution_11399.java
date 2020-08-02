import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Solution_11399 {	
	static int zero[];
	static int one[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		int[] arr = new int[num];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < num; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int[] sum = new int[num];
		
		sum[0] = arr[0];
		int rslt = arr[0];
		for (int i = 1; i < num; i++) {
			sum[i] = arr[i] + sum[i - 1];
			rslt += sum[i];
		}
		System.out.println(rslt);
	}
}