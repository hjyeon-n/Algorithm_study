import java.util.ArrayList;

public class Programmers {
	static int max;
    static ArrayList<String> list;
	public static void main(String[] args) {
    	// TODO Auto-generated method stub
		System.out.println(solution("abcdcba"));
    }
    
	public static int solution(String s) {
        max = 1;
        int len = s.length();
        
        for (int i = 0; i < len; i++) {
            list = new ArrayList<String>();
            String str = String.valueOf(s.charAt(i));
            for (int j = i + 1; j < len; j++) {
                str += String.valueOf(s.charAt(j));
                if (s.charAt(i) == s.charAt(j)) {
                    list.add(str);
                }
            }
            
            if (list.size() >= 1) {
                ispalin();
            }
        }
        return max;
    }
    
    public static void ispalin() {
        for (String str : list) {
        	boolean flag = false;
            if (str.length() % 2 == 0) {
            	flag = evenPalin(str);
            }
            else {
            	flag = oddPalin(str);
            }
            
            if (flag) {
            	max = Math.max(max, str.length());
            }
        }
    }
    
    public static boolean evenPalin(String str) {
    	int num = str.length() / 2;
    	
    	String s = "";
    	for (int i = 0; i < num; i++) {
    		s += String.valueOf(str.charAt(i));
    	}
    	
    	String reverse = "";
    	for (int i = str.length() - 1; i >= num; i--) {
    		reverse += String.valueOf(str.charAt(i));
    	}
    	
    	if (s.equals(reverse)) {
    		return true;
    	}
    	return false;
    }
    
    public static boolean oddPalin(String str) {
    	int num = str.length() / 2;
    	
    	String s = "";
    	for (int i = 0; i < num; i++) {
    		s += String.valueOf(str.charAt(i));
    	}
    	
    	String reverse = "";
    	for (int i = str.length() - 1; i > num; i--) {
    		reverse = String.valueOf(str.charAt(i));
    	}
    	
    	if (s.equals(reverse)) {
    		return true;
    	}
    	return false;
    }
}