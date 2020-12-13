
public class Programmers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("abcde"));
	}

	public static String solution(String s) {
        String answer = "";
        int idx = s.length() / 2;
        
        if (s.length() % 2 == 0) {  
            answer += String.valueOf(s.charAt(idx - 1)) + String.valueOf(s.charAt(idx));
        }
        else {
            answer = String.valueOf(s.charAt(idx));
        }
        return answer;
    }
}