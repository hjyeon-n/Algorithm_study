import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Main {
	@Test
	public static void main(String[] args){
		// TODO Auto-generated method stub
		String t = "3141592";
		String p = "271";
		
		int answer = solution(t, p);
		
		assertEquals(answer, 2);
	}

	public static int solution(String t, String p) {
        int answer = 0;
        int t_len = t.length();
        long num_p = Long.parseLong(p);
        int i = 0;
        int j = p.length();
        
        while (j <= t_len) {
            long num = Long.parseLong(t.substring(i, j));
            
            if (num <= num_p) {
                answer++;
            }
            
            i++;
            j++;
        }
        
        return answer;
    }
}