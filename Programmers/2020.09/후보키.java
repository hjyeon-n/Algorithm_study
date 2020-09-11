import java.util.ArrayList;
import java.util.HashSet;

public class Main {
	static boolean[] visited;
	static int[] arr;
	static ArrayList<String> key;
    static int[] idx;
    static String[][] map;
    
    public static void main(String[] args){
//    	String[][] relation = {{"100","ryan","music","2"},
//				{"200","apeach","math","2"},
//				{"300","tube","computer","3"},
//				{"400","con","computer","1"},
//				{"500","muzi","music","3"},
//				{"600","apeach","music","2"}}; 
//    	String[][] relation = {{"a", "1", "4"}, {"b", "2", "5"}, {"c", "3", "4"}};
    	String[][] relation = {{"b", "2", "a", "a", "b"},{"b","2","7","1","b"},{"1","0","a","a","8"},
    							{"7","5","a","a","9"},{"3","0","a","f","9"}};
		System.out.println(solution(relation));
    }
    
    public static int solution(String[][] relation) {
    	key = new ArrayList<String>();
        map = relation;
        idx = new int[relation[0].length];

        for (int i = 0; i < relation[0].length; i++) {
        	idx[i] = i;
        }
        // 뽑는 수를 반복문으로 늘려가면서 모든 경우 탐색
        for (int i = 1; i <= relation[0].length; i++) {
        	arr = new int[idx.length];
        	visited = new boolean[idx.length];

        	comb(idx.length, i, 0, 0);
        }
        
        return key.size();
    }

    public static void comb(int n, int m, int depth, int index) {
		if (depth == m) {
			uniqueCheck(m);
			return;
		}
	 
		for (int i = index; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = idx[i];	
				comb(n, m, depth + 1, i);
				visited[i] = false;
			}
		}
	}
    
    public static void uniqueCheck(int m) {
        HashSet<String> set = new HashSet<String>();
        for (int j = 0; j < map.length; j++) {
            String str = "";
            for (int i = 0; i < m; i++) {
                str += map[j][arr[i]];
                str += " ";
            }
            set.add(str);
        }
        
        String str = "";
        if (set.size() == map.length) {
        	for (int i = 0; i < m; i++) {
                str += arr[i] + " ";
            }
        	
        	for (int i = 0; i < key.size(); i++) {
        		String keyStr = key.get(i);
        		int equal = 0;
        		for (int j = 0; j < keyStr.length(); j++) {
        			if (str.contains(String.valueOf(keyStr.charAt(j)))) {
    	        		equal++;
    	        	}
        		}
        		if (equal == keyStr.length()) {
        			return;
        		}
        	}
        	key.add(str);
        }
    }
}