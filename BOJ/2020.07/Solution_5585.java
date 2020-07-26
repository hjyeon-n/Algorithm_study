import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_5585 {	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int money = 1000- Integer.parseInt(br.readLine());
		int[] change = {500, 100, 50, 10, 5, 1};
		int count = 0;
		
		int i = 0;
		while (true) {
			if (change[i] <= money) {
				count += money / change[i]; 
				money = money % change[i];
			}
			i++;
			
			if(i > change.length - 1 || money == 0) {
				break;
			}
		}
		System.out.println(count);
	}
}