import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Solution_1991 {    
	static Map<String, List<String>> map = new HashMap<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			String[] tmp = br.readLine().split(" ");
			List<String> list = new ArrayList<>();
			
			list.add(tmp[1]); 
			list.add(tmp[2]);
			map.put(tmp[0], list);
		}
		preorder("A");
		System.out.println("");
		inorder("A");
		System.out.println("");
		postorder("A");
		System.out.println("");
	}
	
	public static void preorder(String key) {
		if (key.equals(".")) {
			return;
		}
		System.out.print(key);
		preorder(map.get(key).get(0));
		preorder(map.get(key).get(1));
	}
	
	public static void inorder(String key) {
		if (key.equals(".")) {
			return;
		}
		inorder(map.get(key).get(0));
		System.out.print(key);
		inorder(map.get(key).get(1));
	}
	
	public static void postorder(String key) {
		if (key.equals(".")) {
			return;
		}
		postorder(map.get(key).get(0));
		postorder(map.get(key).get(1));
		System.out.print(key);
	}
}