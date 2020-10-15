import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class 11656_ver1 {
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len = str.length();
		
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < len; i++) {
			int cnt = i;
			String listStr = "";
			while (cnt < len) {
				listStr += String.valueOf(str.charAt(cnt));
				cnt++;
			}
			list.add(listStr);
		}
		
		Collections.sort(list);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}