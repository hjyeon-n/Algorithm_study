public class Programmers {
	public static void main(String[] args) {
    	// TODO Auto-generated method stub
		System.out.println(solution("a234"));
    }
    
	public static boolean solution(String s) {       
        int len = s.length();
        
        if (len == 4 || len == 6) {
            for (int i = 0; i < len; i++) {
                if (!Character.isDigit(s.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}