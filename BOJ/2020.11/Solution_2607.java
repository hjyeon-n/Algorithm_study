import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Solution_2607 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());
		String[] arr = new String[num];
		
		for (int i = 0; i < num; i++) {
			arr[i] = br.readLine();
		}
		
		HashMap<Character, Integer> strHash = new HashMap<Character, Integer>();
		String str = arr[0];
		int str_len = str.length();
		int cnt = 0;
		
		for (int i = 0; i < str_len; i++) {
			char alpha = str.charAt(i);
			if (strHash.containsKey(alpha)) {
				strHash.put(alpha, strHash.get(alpha) + 1);
			}
			else {
				strHash.put(alpha, 1);
			}
		}
		HashMap<Character, Integer> copy = (HashMap<Character, Integer>) strHash.clone();
		
		for (int i = 1; i < num; i++) {
			int len = arr[i].length();
			boolean[] visited = new boolean[len];
			int diff = 0;
			strHash = (HashMap<Character, Integer>) copy.clone();
			
			if (str_len - len >= 2) {
				continue;
			}
			
			for (int j = 0; j < len; j++) {
				if (diff >= 2) {
					break;
				}
				
				char alpha = arr[i].charAt(j);
//				단어가 해쉬 안에 있고, 아직 변경하지 않았다면
				if (strHash.containsKey(alpha)) {
//					해쉬 값이 0 이상일 때
					if (strHash.get(alpha) > 0) {
						strHash.put(alpha, strHash.get(alpha) - 1);
					}
//					해쉬 값이 0 이하일 때 -> 더 이상 감소시킬 수 없음. 즉, 차이점 발견
					else {
						diff++;
					}
				}
				else {
					diff++;
				}
				visited[j] = true;
			}
			
			for (int j = 0; j < len; j++) {
				if (!visited[j]) {
					diff++;
				}
			}
			
			if (len < str_len) {
				diff += str_len - len;
			}
			
			if (diff <= 1) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}