import java.util.ArrayList;
import java.util.HashMap;

public class Programmers {    
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
    	int[] arr = solution("ABABABABABABABAB");
    	for (int i = 0; i < arr.length; i++) {
    		System.out.println(arr[i]);
    	}
    }

    public static int[] solution(String msg) {
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        
//         사전 채우기
        for (int i = 1; i <= 26; i++) {
            map.put(Character.toString((char)(64 + i)), i);
        }
        
        int len = 26;
        int i = 0;
        while (i < msg.length()) {
            int j = i;
            String str = "";
            int val = 0;
            int k = 1;
            while (j < msg.length()) {
                str += String.valueOf(msg.charAt(j));
                if (map.containsKey(str)) {
                	k = 1;
                    val = map.get(str);
                    int size = str.length();
                    while (size >= 2) {
                    	k++;
                    	size--;
                    }
                }
                else {
                    map.put(str, ++len);
                    break;
                }
                j++;
            }
            list.add(val);
            i = k + i;
        }
        
        int[] answer = new int[list.size()];
        for (int idx = 0; idx < list.size(); idx++) {
            answer[idx] = list.get(idx); 
        }
        
        return answer;
    }
}