import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Programmers {
	static int cnt;
    static boolean[] visited;
    static int[] arr;
    static int[] answer;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
		int[] arr = solution(operations);
		System.out.print(arr[0] + " " + arr[1]);
	}
	
	public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        int len = operations.length;
        PriorityQueue<Integer> minQ = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for (int i = 0; i < len; i++) {
            String str = operations[i];
            StringTokenizer st = new StringTokenizer(str);
            
            String command = st.nextToken();
            int n = Integer.parseInt(st.nextToken());
            
            if (command.equals("I")) {
                minQ.offer(n);
                maxQ.offer(n);
            }
            else {
        		if (minQ.isEmpty()) {
        			continue;
        		}
        		else {
        			if (n == 1) {
        				int val = maxQ.poll();
        				Stack<Integer> tmp = new Stack<Integer>(); 
        				while (true) {
        					int poll = minQ.poll();
        					if (poll == val) {
        						break;
        					}
        					tmp.push(poll);
        				}
        					
        				minQ.addAll(tmp);
        			}
        			else {
        				int val = minQ.poll();
        				Stack<Integer> tmp = new Stack<Integer>(); 
        				while (true) {
        					int poll = maxQ.poll();
        					if (poll == val) {
        						break;
        					}
        					tmp.push(poll);
        				}
        					
        				maxQ.addAll(tmp);
        			}
        		}
        	}
        }
        
        if (minQ.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        }
        else {
            answer[0] = maxQ.poll();
            answer[1] = minQ.poll();
        }
        return answer;
    }
}