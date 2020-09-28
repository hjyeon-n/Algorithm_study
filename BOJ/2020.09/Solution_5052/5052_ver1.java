import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 5052_ver1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int caseNum = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < caseNum; i++) {
			int n = Integer.parseInt(br.readLine());
			String[] phone_book = new String[n];
			
			for (int j = 0; j < n; j++) {
				phone_book[j] = br.readLine();
			}
			
			if (solution(phone_book)) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		} 
	}
	
	public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        int len = phone_book.length;

        for (int i = 0; i < len - 1; i++) {
        	if (phone_book[i + 1].startsWith(phone_book[i])) {
        		return false;
        	}
        }
        return true;
    }
}