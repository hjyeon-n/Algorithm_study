import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1057 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()) - 1;
		int L = Integer.parseInt(st.nextToken()) - 1;
		
		int K_n = K;
		int L_n = L;
		int round = 1;
		
		while (true) {
			K_n /= 2;
			L_n /= 2;
			
			if (K_n == L_n) {
				System.out.println(round);
				break;
			}
			
			if (K_n % 2 == 0 && L_n - K_n == 1) {
				System.out.println(round + 1);
				break;
			}
			round++;
		}
		
		
	}
}