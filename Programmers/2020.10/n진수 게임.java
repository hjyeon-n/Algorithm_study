import java.util.ArrayList;

public class Programmers {    
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
    	System.out.println(solution(16, 16, 2, 1));
    }

    public static String solution(int n, int t, int m, int p) {
        String answer = "";
        Character[] arr = new Character[m * t];
        arr = convertNum(arr, n, arr.length);
        int people = 1;
        
        for (int i = 0; i < arr.length; i++) {
            if (people == p) {
                answer += String.valueOf(arr[i]);
            }
            
            if (people == m) {
                people = 0;
            }
            people++;
        }
        return answer;
    }
    
    public static Character[] convertNum(Character[] arr, int n, int size) {
        int num = 1;
        int idx = 1;
        int tmp = 1;
        ArrayList<Character> list;
        arr[0] = 0 + '0';
        while (idx < size - 1) {
        	list = new ArrayList<Character>();
            while (num > 0) {
                if (num % n >= 10) {
                    list.add((char)((num % n) + 55));
                }
                else {
                    list.add((char)(num % n + '0'));
                }
                num = num / n;
            }
            for (int i = list.size() - 1; i >= 0; i--) {
            	arr[idx++] = list.get(i);
            	if (idx == size) {
            		return arr;
            	}
            }
            tmp++;
            num = tmp;
        }
        return arr;
    }
}