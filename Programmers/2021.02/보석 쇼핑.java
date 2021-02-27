import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Programmers {
	static int cnt;
    static boolean[] visited;
    static int[] arr;
    static int[] answer;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		int[] arr = solution(gems);
		
		System.out.println(arr[0] + " " + arr[1]);
	}
	
	public static int[] solution(String[] gems) {
        int[] answer = {};
        HashSet<String> set = new HashSet<String>();
        
        for (int i = 0; i < gems.length; i++) {
            set.add(gems[i]);    
        }
        
        int min = 100001;
        int size = set.size();
        ArrayList<int[]> list = new ArrayList<int[]>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int s = 0, e = 0;
        
        while (true) {
            if (size <= map.size()) {
            	map.put(gems[s], map.get(gems[s]) - 1);
            	if (map.get(gems[s]) == 0) {
            		map.remove(gems[s]);
            	}
                s++;
            }    
            else if (e == gems.length) {
                break;
            }
            else {
            	if (map.containsKey(gems[e])) {
            		map.put(gems[e], map.get(gems[e]) + 1);
            	}
            	else {
            		map.put(gems[e], 1);
            	}
                e++;
            }
            
            if (size == map.size()) {
                if (min > e - s + 1) {
                    min = e - s + 1;
                    list = new ArrayList<int[]>();
                    list.add(new int[] {s + 1, e});
                }
                else if (min == e - s + 1) {
                    list.add(new int[] {s + 1, e});
                }
            }
        }
        
        answer = list.get(0);
        return answer;
    }
}