import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Programmers {    
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
//    	int[] arr = {1, 2, 3, 2, 3, 1};
    	int[] answer = solution("{{4,2,3},{3},{2,3,4,1},{2,3}}");
//    	
    	for (int i = 0; i < answer.length; i++) {
    		System.out.print(answer[i] + " ");
    	}
    }

    public static int[] solution(String s) {
        s = s.substring(1, s.length() - 1);
        
        ArrayList<String> list = new ArrayList<String>();
        
        int flag = 0;
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{') {
                flag = 1;
                continue;
            }
            
            if (s.charAt(i) == '}') {
                flag = 0;
                continue;
            }
            
            if (flag == 1) {
            	if (s.charAt(i) == ',') {
            		str += " ";
            	}
            	else {
            		str += String.valueOf(s.charAt(i));
            	}
            }
            
            if (flag == 0) {
                list.add(str);
                str = "";
                flag = 0;
            }
        }
        
        if (flag == 0) {
            list.add(str);
            str = "";
            flag = 0;
        }
        
        Comparator<String> comparator = new Comparator<String>() { 
        	public int compare(String s1, String s2) { 
        		return Integer.compare(s1.length(), s2.length()); 
        	} 
        }; 
        Collections.sort(list, comparator);
        
        ArrayList<Integer> answerList = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++) {
            String[] arr_str = list.get(i).split(" ");
            for (int j = 0; j < arr_str.length; j++) {
            	if (!answerList.contains(Integer.parseInt(arr_str[j]))) {
            		answerList.add(Integer.parseInt(arr_str[j]));
            	}
            }
        }
        
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
        	answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}