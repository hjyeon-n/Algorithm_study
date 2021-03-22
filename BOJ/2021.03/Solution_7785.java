import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;
public class Solution_7785 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<String>();
		StringTokenizer st;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String comm = st.nextToken();
			
			if (comm.equals("enter")) {
				set.add(name);
			}
			else {
				set.remove(name);
			}
		}
		
		ArrayList<String> company = new ArrayList<String>(set);
		Collections.sort(company, Collections.reverseOrder());
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < company.size(); i++) {
			sb.append(company.get(i) + "\n");
		}
		System.out.println(sb.toString());
	}
}