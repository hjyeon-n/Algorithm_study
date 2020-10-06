import java.util.ArrayList;

public class Programmers {    
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
    	int[] priorities = {2, 1, 3, 2};
    	
    	System.out.println(solution(priorities, 2));
    }
    
    public static int solution(int[] priorities, int location) {
        int len = priorities.length;
        ArrayList<Print> list = new ArrayList<Print>();
        ArrayList<Integer> end = new ArrayList<Integer>(); 
        
        for (int i = 0; i < len; i++) {
            list.add(new Print(i, priorities[i]));
        }
        
        while (list.size() != 0) {
            Print print = list.remove(0);
            boolean flag = false;
            for (int i = 0; i < list.size(); i++) {
                if (print.priority < list.get(i).priority) {
                    flag = true;
                    break;
                }
            }
            
            if (flag) {
                list.add(print);
            }
            else {
                end.add(print.idx);
            }
        }
        
        int answer = 0;
        for (int i = 0; i < len; i++) {
            if (end.get(i) == location) {
                answer = i + 1;
                break;
            }
        }
        return answer;
    }
}

class Print {
    int idx;
    int priority;
    
    public Print(int idx, int priority) {
        this.idx = idx;
        this.priority = priority;
    }
}