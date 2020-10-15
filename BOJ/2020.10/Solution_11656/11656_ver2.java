import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class 11656_ver2 {
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len = str.length();
		
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < len; i++) {
			list.add(str.substring(i, len));
		}
		
		Collections.sort(list);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}