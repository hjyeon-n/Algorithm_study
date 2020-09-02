public class Main {
    
    public static void main(String[] args){
		System.out.println(solution("xababcdcdababcdcd"));
    }

    public static int solution(String s) {
    	int answer = s.length();

    	for (int i = 1; i <= s.length() / 2; i++) {
    		int length = s.length() / i + 1;
    		String str[] = new String[length];

    		int k = 0;
    		int remain = s.length();
    		for (int j = 0; j < length; j++) {
    			if (remain < i) {
    				str[j] = s.substring(k, s.length());
    				break;
    			}
    			str[j] = s.substring(k, k + i);
    			k = k + i;
    			remain -= i;
    		}

    		String newStr = "";
    		int cnt = 0;
    		int idx = 0;
    		int m = 0;
    		
    		while(true) {
    			idx = cnt + idx;
    			cnt = 1;
    			
    			if (idx >= str.length - 1) {
    				newStr += str[str.length - 1]; 
    				break;
    			}

    			m = 0;
    			while (str[idx].equals(str[idx + 1])) {
    				idx += 1;
    				cnt++;
    				m++;
    				
    				if (idx == str.length - 1) {
    					break;
    				}
    			}
    			idx -= m;
    			if (cnt > 1) {
    				newStr += cnt + str[idx];
    			}
    			else {
    				newStr += str[idx];
    			}
    		}
			answer = Math.min(answer, newStr.length());
    	}
    	return answer;
    }
}