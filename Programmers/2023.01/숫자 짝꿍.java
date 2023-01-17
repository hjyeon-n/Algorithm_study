import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Main {
	@Test
	public static void main(String[] args){
		// TODO Auto-generated method stub
		String X = "12321";
		String Y = "42531";
		
		String answer = solution(X, Y);
		
		assertEquals(answer, "321");
	}

	public static String solution(String X, String Y) {
        int[] digit_x = new int[10];
        int[] digit_y = new int[10];
        String answer = "";
        StringBuffer sb = new StringBuffer();
        
        digit_x = cal(X, digit_x);
        digit_y = cal(Y, digit_y);
        
        for (int i = 9; i >= 0; i--) {
            if (digit_x[i] != 0 && digit_y[i] != 0){
                int cnt = Math.min(digit_x[i], digit_y[i]);
                
                for (int j = 0; j < cnt; j++) {
                    sb.append(String.valueOf(i));
                }
            }
        }
        
        answer = sb.toString();
        
//         Â¦²á ¼ö°¡ ¾øÀ¸¸é -1 ¹ÝÈ¯
        if (answer.length() < 1) {
            return "-1";
        }
        
//         Â¦²á ¼ö ÃÖ´ñ°ªÀÌ 0ÀÌ¸é
        if (answer.charAt(0) == '0') {
            return "0";
        }
                
        return answer;
    }
    
    public static int[] cal(String str, int[] digit) {
        for (int i = 0; i < str.length(); i++) {
            int n = str.charAt(i) - '0';
            digit[n]++;
        }
        return digit;
    }
}