import java.util.ArrayList;

public class Programmers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("heLlo         World"));
	}

	public static String solution(String s) {
		String answer = "";
        String tmp = ""; 
        ArrayList<String> list = new ArrayList<String>();
        
        for (int i = 0; i < s.length(); i++) {
            if (String.valueOf(s.charAt(i)).equals(" ")) {
                list.add(tmp);
                tmp = "";
                list.add(" ");
            }
            else {
                tmp += String.valueOf(s.charAt(i));
            }
        }
        
        list.add(tmp);
        
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            
            if (str.length() <= 1) {
                answer += str.toUpperCase();
                continue;
            }

            String capitalize = str.substring(0, 1);
            answer += capitalize.toUpperCase();
            String lower = str.substring(1);
            answer += lower.toLowerCase();       
        }
        return answer;     
    }
}