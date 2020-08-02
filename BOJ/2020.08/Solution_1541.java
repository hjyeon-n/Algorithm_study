import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Solution_1541 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int[] operand = new int[str.length()];
		char[] operator = new char[str.length()];
		char[] arr = new char[5];
		
		int i = 0;
		int j = 0;
		int arr_len = 0;
		for (int loop = 0; loop < str.length(); loop++) {
			char tmp = str.charAt(loop);
	
			if (tmp != '+' && tmp != '-') {
				arr[arr_len++] = tmp;
			}
			
			if (tmp == '+' || tmp == '-') {
				String num = "";
				for (int m = 0; m < arr.length; m++) {
					num += Character.toString(arr[m]);
					arr[m] = 0;
				}
				num = num.trim();
				operator[i++] = tmp;
				operand[j++] = Integer.parseInt(num);
				arr_len = 0;
			}
		}
		String num = "";
		for (int m = 0; m < arr.length; m++) {
			num += Character.toString(arr[m]);
			arr[m] = 0;
		}
		num = num.trim();
		operand[j++] = Integer.parseInt(num);
		
		int rslt = operand[0];
		int flag = 1;
		for (i = 0; i < operator.length - 1; i++) {
			if (operator[i] == '+' && flag == 1) {
				rslt += operand[i + 1];
			}
			else {
				rslt -= operand[i + 1];
				flag = 0;
			}
		}		
		System.out.println(rslt);
	}	
}