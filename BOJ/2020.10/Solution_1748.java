import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1748 {
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		int cnt = 1;
		int num = 10;
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			if(i % num == 0) {
				cnt++;
				num *= 10;
			}
			answer += cnt;
		}
		System.out.println(answer);
	}
}