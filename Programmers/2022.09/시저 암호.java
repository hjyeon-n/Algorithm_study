public class Main {
	public static void main(String[] args){
		// TODO Auto-generated method stub
		System.out.println(solution("a B z", 4));
	}

	public static String solution(String s, int n) {
        String answer = "";
       
        // a = 97, z = 122
        // A = 65, Z = 90
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int tmp = ch + n;
            
            if (ch >= 65 && ch <= 90) {    
                if (tmp / 91 != 0) {
                    tmp = tmp % 91 + 65;
                }
                
                ch = (char)tmp;
            }
            else if (ch >= 97 && ch <= 122){
                if (tmp / 123 != 0) {
                    tmp = tmp % 123 + 97;
                }
                
                ch = (char)tmp;
            }
            
            answer += String.valueOf(ch);
        }
    
        return answer;
    }
}