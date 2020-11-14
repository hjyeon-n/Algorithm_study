public class Programmers {
	public static void main(String[] args) {
    	// TODO Auto-generated method stub
		System.out.println(solution("abcdcba"));
    }
    
	public static int solution(String s) {
        for (int len = s.length(); len > 1; len--) {
            for (int start = 0; start + len <= s.length(); start++) {
                boolean flag = true;
                
                for (int i = 0; i < len / 2; i++) {
                    if (s.charAt(start + i) != s.charAt(start + len  - i - 1)) {
                        flag = false;
                        break;
                    }
                }
                
                if (flag) {
                	return len;
                }
            }
        }
        return 1;
    }
}