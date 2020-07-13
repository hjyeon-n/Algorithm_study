import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Solution_11047 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] coin = new int[n];
		
		for (int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		int rslt = 0;
		for (int i = n - 1; i >= 0; i--)	{
			if (k >= coin[i]) {
				rslt += k / coin[i];
				k = k % coin[i];
			}
		}
		System.out.println(rslt);
	}
}