import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Solution_1932 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
	
//		Scanner scan = new Scanner(System.in);
//		int n = scan.nextInt();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int arr[][] = new int[n + 1][n + 1];
		int max = -1;
				
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= i; j++) {	
				if (st.hasMoreTokens()) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
				if(j == 1)
					arr[i][j] += arr[i - 1][j];
				else if(j == i)
					arr[i][j] += arr[i - 1][j - 1];
				else
					arr[i][j] += Math.max(arr[i - 1][j - 1], arr[i - 1][j]);
				
				max = Math.max(max, arr[i][j]);
			}			
		}
		System.out.println(max);
	}
}