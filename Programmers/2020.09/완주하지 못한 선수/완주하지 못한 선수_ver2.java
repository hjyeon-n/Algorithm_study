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
        for (String player : participant) {
            map.put(player, map.getOrDefault(player, 0) + 1);
        }
        
        for (String player : completion) {
            map.put(player, map.get(player) - 1);
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
