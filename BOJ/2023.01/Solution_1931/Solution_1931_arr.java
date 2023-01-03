import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Solution_1931_arr {
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int arr[][] = new int[n][2];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, (a, b) -> a[1] == b[1] ?  a[0] - b[0] : a[1] - b[1]);

		int cnt = 0;    
		int end = -1;   
		for (int i = 0; i < n; i++) {
			if (arr[i][0] >= end) {
				end = arr[i][1];    
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}