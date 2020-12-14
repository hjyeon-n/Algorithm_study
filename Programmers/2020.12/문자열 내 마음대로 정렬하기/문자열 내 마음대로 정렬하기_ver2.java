import java.util.ArrayList;
import java.util.Collections;

public class Programmers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strings = {"sun", "bed", "car"};
		String[] answer = solution(strings, 1);
		
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

	public static String[] solution(String[] strings, int n) {
		String[] answer = {};
        ArrayList<String> arr = new ArrayList<String>();
        
        for (int i = 0; i < strings.length; i++) {
            arr.add("" + strings[i].charAt(n) + strings[i]);
        }
        
        Collections.sort(arr);
        
        answer = new String[arr.size()];
        
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i).substring(1, arr.get(i).length());
        }
        
        return answer;
	}
}