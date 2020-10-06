import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Programmers {    
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
    	int bridge_length = 2;
    	int weight = 10;
    	int[] truck_weights = {7, 4, 5, 6};
    	
    	System.out.println(solution(bridge_length, weight, truck_weights));
    }
    
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int truck_len = truck_weights.length;
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int i = truck_len - 1; i >= 0; i--) {
            stack.push(truck_weights[i]);
        } 
    
        ArrayList<Integer> end = new ArrayList<Integer>();
        Queue<Truck> bridge = new LinkedList<Truck>();
        
        int answer = 1;
        int sum = 0;
        while (true) {
            if (bridge.size() == 0) {
                int num = stack.pop();
                bridge.add(new Truck(answer, num));
                sum = num;
            }
            else {
            	if (answer - bridge.peek().time == bridge_length) {
                	int truck = bridge.poll().val;
                	end.add(truck);
                	sum -= truck;
                }
            	
            	if (end.size() == truck_len) {
                    break;
                }
            	
                if (!stack.isEmpty() && sum + stack.peek() <= weight) {
                    int num = stack.pop();
                    bridge.add(new Truck(answer, num));
                    sum += num;
                }
            }
            answer++;
        }
        
        return answer;
    }
}

class Truck {
	int time;
	int val;
	
	public Truck (int time, int val) {
		this.time = time;
		this.val = val;
	}
}