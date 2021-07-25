import java.util.HashMap;

public class Main {
	public static void main(String[] args){
		// TODO Auto-generated method stub
		System.out.println(solution("one4seveneight"));
	}

	public static int solution(String s) {
        String answer = "";
        int len = s.length();
        String tmp = "";
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        
        for (int i = 0; i < len; i++) {
            char alpha = s.charAt(i);
            
            if (0 <= alpha - '0' && alpha - '0' <= 9) {
                answer += alpha;
            }
            else {
                tmp += alpha;
                if (map.containsKey(tmp)) {
                    answer += map.get(tmp);
                    tmp = "";
                }
            }      
        }
        
        if (tmp.length() > 0) {
            answer += map.get(tmp);
        }
        
        return Integer.parseInt(answer);
    }
}