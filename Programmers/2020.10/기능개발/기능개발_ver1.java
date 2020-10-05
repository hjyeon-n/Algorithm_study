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
        Stack<Progress> stack = new Stack<Progress>();
        int len = progresses.length;
        for (int i = len - 1; i >= 0; i--) {
            int p = progresses[i];
            int s = speeds[i];
            int day = 1;
            while (true) {
                if (p + s * day >= 100) {
                    break;
                }
                day++;
            }
            stack.push(new Progress(p, day));
        }
        
        while (!stack.isEmpty()) {
            int cnt = 1;
            Progress pro = stack.pop();
            
            while (true) {
                if (!stack.isEmpty()) {
                    if (stack.peek().day <= pro.day){
                        stack.pop();
                        cnt++;
                    }
                    else {
                        break;
                    }
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

class Progress {
    int work;
    int day;
    
    public Progress (int work, int day) {
        this.work = work;
        this.day = day;
    }
}