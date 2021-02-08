public class Programmers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
	}
	
	public static String solution(String new_id) {
        new_id = new_id.toLowerCase();
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");
        
        boolean flag = false;
        String answer = "";
        for (int i = 0; i < new_id.length(); i++) {
            char alpha = new_id.charAt(i);
            if (alpha == '.' && flag) {
                continue;
            }
            
            if (alpha == '.') {
                flag = true;
            }
            else {
                flag = false;
            }
            answer += String.valueOf(alpha);
        }
        
        if (answer.length() >= 1 && answer.charAt(0) == '.') {
            answer = answer.substring(1);
        }

        if (answer.length() >= 1 && answer.charAt(answer.length()- 1) == '.') {
            answer = answer.substring(0, answer.length() - 1);
        }
        
        if (answer.length() == 0) {
            answer += "a";
        }
        
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            
            if (answer.charAt(answer.length() - 1) == '.') {
                answer = answer.substring(0, answer.length() - 1);
            }
        }
        
        if (answer.length() <= 2) {
            char alpha = answer.charAt(answer.length() - 1);
            while (answer.length() != 3) {
                answer += String.valueOf(alpha);
            }
        }
        return answer;
    }
}