import java.util.ArrayList;
import java.util.Stack;

public class Programmers {    
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
    	int[] progresses = {93, 30, 55};
    	int[] speeds = {1, 30, 5};
    	int[] answer = solution(progresses, speeds);
    	
    	for (int i = 0; i < answer.length; i++) {
    		System.out.println(answer[i]);
    	}
    }
    public static int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        int len = progresses.length;
        
        for (int i = len - 1; i >= 0; i--) {
            double remain = (100 - progresses[i]) / (double)speeds[i];
            int day = (int)Math.ceil(remain);
            stack.push(day);
        }
        
        while (!stack.isEmpty()) {
            int cnt = 1;
            int day = stack.pop();
            
            while (true) {
                if (!stack.isEmpty() && stack.peek() <= day) {
                	stack.pop();
                    cnt++;
                }
                else {
                	break;
                }
            }   
            list.add(cnt);
        }
        
        int size = list.size();
        int[] answer = new int[size];
        
        for (int i = 0; i < size; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}