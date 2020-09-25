import java.util.ArrayList;
import java.util.HashMap;

public class Programmers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
		solution(participant, completion);
	}
	
	public static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < participant.length; i++) {
            if (map.containsKey(participant[i])) {
                map.put(participant[i], map.get(participant[i]) + 1);
            }
            map.put(participant[i], 1);
        }
        
        for (int i = 0; i < completion.length; i++) {
            map.put(completion[i], map.get(completion[i]) - 1);
        }
        
        for (int i = 0; i < participant.length; i++) {
            if (map.get(participant[i]) == 1) {
                answer = participant[i];
                break;
            }
        }
        
        return answer;
    }
}
