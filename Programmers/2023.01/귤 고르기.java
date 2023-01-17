import static org.junit.Assert.assertEquals;
import java.util.*;

import org.junit.Test;

public class Main {
	@Test
	public static void main(String[] args){
		// TODO Auto-generated method stub
		int k = 6;
		int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
		
		int answer = solution(k, tangerine);
		
		assertEquals(answer, 3);
	}

	public static int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < tangerine.length; i++) {
            if (map.containsKey(tangerine[i])) {
                map.put(tangerine[i], map.get(tangerine[i]) + 1);
            }
            else {
                map.put(tangerine[i], 1);
            }
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Comparator<Map.Entry<Integer, Integer>> cmp = Map.Entry.comparingByValue();
        list.sort(cmp.reversed());

        int sum = 0;
        for(Map.Entry<Integer, Integer> entry : list) {
            sum += entry.getValue();
            answer++;

            if (sum >= k) {
                break;
            }
        }

        return answer;
    }
}