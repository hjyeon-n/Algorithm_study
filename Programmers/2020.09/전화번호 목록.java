import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Programmers2 {
	static HashSet<Integer> set;
    static boolean[] visited;
    static int[] arr;
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] phone_book = {"119", "97674223", "1195524421"};
		System.out.println(solution(phone_book));
	}
	
	public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        int len = phone_book.length;
        if (len <= 1) {
            return true;
        }
        HashMap<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < len; i++) {
            map.put(phone_book[i], phone_book[i]);
        }
        
        for (int i = 0; i < len; i++) {
            map.remove(phone_book[i]);
            ArrayList<String> list = new ArrayList<String>(map.values());
            
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).startsWith(phone_book[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
