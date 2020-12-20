import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution_1181 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<String> list = new ArrayList<String>();
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			if (!list.contains(str)) {
				list.add(str);
			}
		}
		
		Collections.sort(list);
		
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int a = o1.length();
				int b = o2.length();
				
				if (a > b) {
					return 1;
				}
				if (a < b) {
					return -1;
				}
				return 0;	
			}
		});
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}