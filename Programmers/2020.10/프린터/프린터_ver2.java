import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers {    
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
    	int[] priorities = {1, 1, 9, 1, 1, 1};
    	System.out.println(solution(priorities, 0));
    }
    
    public static int solution(int[] priorities, int location) {
    	int answer = 0;
        int l = location;

        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i : priorities){
            queue.add(i);
        }

        Arrays.sort(priorities);
        int size = priorities.length - 1;

        while(!queue.isEmpty()){
            Integer i = queue.poll();
            if (i == priorities[size - answer]){
                answer++;
                l--;
                if (l < 0) {
                    break;
                }
            }
            else{
                queue.add(i);
                l--;
                if (l < 0) {
                    l = queue.size() - 1;
                }
            }
        }

        return answer;
    }
}