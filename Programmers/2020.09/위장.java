import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Programmers {
    static HashMap<String, String> map;
    
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
    	String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
    	System.out.println(solution(clothes));
    }

    public static int solution(String[][] clothes) {
        int len = clothes.length;
        map = new HashMap<String, String>(); 
        HashSet<String> set = new HashSet<String>();
        
        for (int i = 0; i < len; i++) {
            map.put(clothes[i][0], clothes[i][1]);
            set.add(clothes[i][1]);
        }
        
        int size = set.size();
        Iterator<String> it = set.iterator();
        
        int answer = 1;
        for (int i = 0; i < size; i++) {
            answer *= getSize(it.next()) + 1;
        }
        answer -= 1;
        
        return answer;
    }
    
    public static int getSize(String value) { 
        int size = 0;
        for(String key : map.keySet()) { 
            if(map.get(key).equals(value)) { 
                size++;
            } 
        } 
        return size;
    }
}
