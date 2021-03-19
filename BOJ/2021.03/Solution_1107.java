import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Solution_1107 {
 	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		if (N == 100) {
			System.out.println("0");
			return;
		}
		
		int min = Math.abs(N - 100);
		if (M == 0) {
			min = Math.min(min, String.valueOf(N).length());
			System.out.println(min);
			return;
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		for (int i = 0; i < 1000001; i++) {
			if (check(i, list)) {
				min = Math.min(min, Math.abs(N - i) + String.valueOf(i).length());
			}
		}
		
		System.out.println(min);
	}
 	
 	public static boolean check(int num, ArrayList<Integer> list) {
 		String str = String.valueOf(num);
 		
 		for (int i = 0; i < str.length(); i++) {
 			int digit = str.charAt(i) - '0';
 			
 			if (list.contains(digit)) {
 				return false;
 			}
 		}
 		return true;
 	}
}