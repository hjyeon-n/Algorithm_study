import java.util.PriorityQueue;

public class Programmers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] scoville = {1, 2, 3, 9, 10, 12};
		System.out.println(solution(scoville, 7));
	}
	
	public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        int len = scoville.length;
        for (int i = 0; i < len; i++) {
            queue.add(scoville[i]);
        }
        
        while (true) {
            if (queue.size() >= 1 && queue.peek() >= K) {
                break;
            }
            
            if (queue.size() <= 1) {
                answer = -1;
                break;
            }
            
            int a = queue.poll();
            int b = queue.poll();
            
            queue.add(a + 2 * b); 
            answer++;
        }
        
        return answer;
    }
}