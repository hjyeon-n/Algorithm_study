import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
public class Solution_1092 {	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Integer[] crane = new Integer[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			crane[i] = Integer.parseInt(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine());
		List<Integer> box = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			box.add(Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(crane, Collections.reverseOrder());
		Collections.sort(box);
		Collections.reverse(box);
		
		int min = 0;
				
		while(!box.isEmpty()) {
			if (min > m) {
				System.out.println("-1");
				return;
			}
			int idx = 0;
			int i = 0;
			while(idx < n) {
				if (box.isEmpty()) {
					break;
				}
				if (crane[idx] >= box.get(i)) {
					box.remove(i);
				}
				else {
					i++;
					if (i < box.size()) {
						continue;
					}
				}
				idx++;
				i = 0;
			}
			min++;
		}
		System.out.println(min);
	}
}