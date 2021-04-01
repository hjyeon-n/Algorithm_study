import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String S = st.nextToken();
		String E = st.nextToken();
		String Q = st.nextToken();
		
		HashSet<String> start = new HashSet<String>();
		HashSet<String> end = new HashSet<String>();
		HashSet<String> set = new HashSet<String>();
		
		int cnt = 0;
		String chat = null;
		
		while ((chat = br.readLine()) != null) {
			String time = chat.split(" ")[0];
			String name = chat.split(" ")[1];
			
			set.add(name);
			if (S.compareTo(time) >= 0) {
				start.add(name);
			}
			else if (E.compareTo(time) <= 0 && Q.compareTo(time) >= 0) {
				end.add(name);
			}
		}
		
		for (String name : set) {
			if (start.contains(name) && end.contains(name)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}