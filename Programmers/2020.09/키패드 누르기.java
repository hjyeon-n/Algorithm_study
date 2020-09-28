import java.util.*;

public class Programmers2 {
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
    	int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
    	System.out.println(solution(numbers, "right"));
    }

    public static String solution(int[] numbers, String hand) {
        String answer = "";
        int len = numbers.length;
        
        ArrayList<Integer> Llist = new ArrayList<Integer>(Arrays.asList(1, 4, 7));
        ArrayList<Integer> Rlist = new ArrayList<Integer>(Arrays.asList(3, 6, 9));
        
        int Llast = 10;
        int Rlast = 12;
        
        for (int i = 0; i < len; i++) {
            int number = numbers[i];
            
            if (Llist.contains(number)) {
                answer += "L";
                Llast = number;
                continue;
            }
            
            if (Rlist.contains(number)) {
                answer += "R";
                Rlast = number;
                continue;
            }
            
            int Ldist = countDist(Llast, number);
            int Rdist = countDist(Rlast, number);
            
            if (Ldist > Rdist) {
                Rlast = number;
                answer += "R";
            }
            else if (Ldist < Rdist) {
                Llast = number;
                answer += "L";
            }
            else {
                if (hand.equals("left")) {
                    Llast = number;
                    answer += "L";
                }
                else {
                    Rlast = number;
                    answer += "R";
                }
            }
        }
        return answer;
    }
    
    public static int countDist(int last, int number) {
    	if (number == 0) {
    		number = 11;
    	}
    	if (last == 0) {
    		last = 11;
    	}
        int l_x = (last - 1) / 3;
        int l_y = (last  - 1) % 3;
        int n_x = (number - 1) / 3;
        int n_y = (number - 1) % 3;
        
        return Math.abs(l_x - n_x) + Math.abs(l_y - n_y);
    }
}
