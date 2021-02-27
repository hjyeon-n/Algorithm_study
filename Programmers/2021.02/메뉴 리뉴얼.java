import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Programmers {
	static boolean[] visited;
    static char[] alpha;
    static char[] arr;
    static ArrayList<String> list;
    static int max;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course = {2, 3, 4};
		String[] arr = solution(orders, course);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static String[] solution(String[] orders, int[] course) {
		HashSet<Character> set = new HashSet<Character>();
        
        for (int i = 0; i < orders.length; i++) {
            String str = orders[i];
            
            for (int j = 0; j < str.length(); j++) {
                set.add(str.charAt(j));
            }
        }
        
        int size = set.size();
        arr = new char[size];
        ArrayList<Character> tmp = new ArrayList<Character>();
        tmp.addAll(set);
        
        for (int i = 0; i < size; i++) {
            arr[i] = tmp.get(i);
        }
        
        Arrays.sort(arr);
        
        ArrayList<String> answerList = new ArrayList<String>();
        for (int i = 0; i < course.length; i++) {
            visited = new boolean[size];
            alpha = new char[size];
            max = -1;
            list = new ArrayList<String>();
            dfs(size, course[i], 0, 0, orders);
            answerList.addAll(list);
        }
        
        Collections.sort(answerList);
        String[] answer = new String[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
    
    public static void dfs(int n, int m, int depth, int idx, String[] orders) {
        if (depth == m) {
        	boolean flag = true;
        	int cnt = 0;
            for (int i = 0; i < orders.length; i++) {
            	String str = orders[i];
            	for (int j = 0; j < m; j++) {
	            	if (!str.contains(String.valueOf(alpha[j]))) {
	            		flag = false;
	            		break;
	            	}
            	}
            	
            	if (flag) {
            		cnt++;
            	}
            	flag = true;
            }
            
            if (cnt > max && cnt >= 2) {
            	max = cnt;
            	list = new ArrayList<String>();
            	String rslt = "";
            	for (int i = 0; i < m; i++) {
            		rslt += String.valueOf(alpha[i]);
            	}
            	list.add(rslt);
            }
            else if (cnt == max && cnt >= 2) {
            	String rslt = "";
            	for (int i = 0; i < m; i++) {
            		rslt += String.valueOf(alpha[i]);
            	}
            	list.add(rslt);
            }
            
            return;
        }
        
        for (int i = idx; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                alpha[depth] = arr[i]; 
                dfs(n, m, depth + 1, i, orders);
                visited[i] = false;
            }
        }
    }
}