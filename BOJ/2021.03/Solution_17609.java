import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_17609 {
    public static void main(String[] args) throws IOException{
    	// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
        	String str = br.readLine();
        	System.out.println(isPalindrome(str));
        }
    }
    
    public static int isPalindrome(String str) {
    	int start = 0;
    	int end = str.length() - 1;
    	int cnt = 0;
    	
    	while (start <= end) {
    		if (str.charAt(start) != str.charAt(end)) {
    			if (cnt == 0) {
    				int tmp_s = start;
    				int tmp_e = end - 1;
    				int l_cnt = 0;
    				int r_cnt = 0;
    				
    				if (str.charAt(tmp_s) == str.charAt(tmp_e)) {
    					r_cnt++;
    					while (tmp_s <= tmp_e) {
    						if (str.charAt(tmp_s) != str.charAt(tmp_e)) {
    							r_cnt++;
    							break;
    						}
    						tmp_s++;
    						tmp_e--;
    					}
    				}
    				else {
    					r_cnt = 2;
    				}
    				
    				tmp_s = start + 1;
    				tmp_e = end;
    				if (str.charAt(tmp_s) == str.charAt(tmp_e)){
    					l_cnt++;
    					while (tmp_s <= tmp_e) {
    						if (str.charAt(tmp_s) != str.charAt(tmp_e)) {
    							l_cnt++;
    							break;
    						}
    						tmp_s++;
    						tmp_e--;
    					}
    				}
    				else {
    					l_cnt = 2;
    				}
    				
    				cnt = Math.min(l_cnt, r_cnt);
    				
    				if(cnt == 1) {
    					return 1;
    				}
    				else {
    					return 2;
    				}
    			}
    		}
    		start++;
    		end--;
    	}
    	
    	return 0;
    }
}