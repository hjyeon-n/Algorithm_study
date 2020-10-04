import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Programmers {    
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
    	String[] arr = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
    	String[] rslt = solution(arr);
    	for (int i = 0; i < rslt.length; i++) {
    		System.out.println(rslt[i]);
    	}
    }
    public static String[] solution(String[] files) {
        int len = files.length;
        FileName[] names = new FileName[len];
        ArrayList<Character> list = new ArrayList<Character>();
        
        for (int i = 0; i < 10; i++) {
            list.add((char)(48 + i));
        }
        
        for (int i = 0; i < len; i++) {
            String name = files[i];
            int name_len = name.length();
            
            int j;
            boolean flag = true;
            String head = "";
            String number = "";
            String tail = "";
            for (j = 0; j < name_len; j++) {
                char c = name.charAt(j);
                if (flag && !list.contains(c)) {
                    head += String.valueOf(c);
                }
                else if(list.contains(c)) {
                    number += String.valueOf(c);
                }
                else {
                	break;
                }
                
                if (!number.equals("")) {
                    flag = false;
                }
            }
            
            while (j < name_len){
                tail += String.valueOf(name.charAt(j));
                j++;
            }
            
            names[i] = new FileName(name, head, number, Integer.parseInt(number), tail);
        }
        
        Arrays.sort(names, new Comparator<FileName>() {
            @Override
            public int compare(FileName o1, FileName o2) {
                String a = o1.head;
                String b = o2.head;
                
                if (a.compareToIgnoreCase(b) < 0) {
                	return -1;
                }
                if (a.compareToIgnoreCase(b) > 0) {
                	return 1;
                }
                else  {
                	int num1 = o1.realNum;
                    int num2 = o2.realNum;
                    if (num1 > num2) {
                        return 1;
                    }
                    if (num1 < num2) {
                        return -1;
                    }
                    return 0;	
                }
            }
        });
        
        String[] answer = new String[len];
        for (int i = 0; i < len; i++) {
            answer[i] = names[i].name;
        }
        return answer;
    }
}

class FileName {
    String name;
    String head;
    String number;
    int realNum;
    String tail;
	
    public FileName(String name, String head, String number, int realNum, String tail) {
		super();
		this.name = name;
		this.head = head;
		this.number = number;
		this.realNum = realNum;
		this.tail = tail;
	}
}