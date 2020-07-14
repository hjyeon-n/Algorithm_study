import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_2217 {	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int[] rope = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			rope[i] = arr[i] * (n - i + 1);
		}
		
		Arrays.sort(rope);
		System.out.println(rope[n]);
	}
}