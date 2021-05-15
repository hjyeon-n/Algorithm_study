import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static ArrayList<ArrayList<Integer>> graph;
	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		int[] times = {7, 10};
		System.out.println(solution(6, times));
	}
	
	public static long solution(int n, int[] times) {
		long answer = Long.MAX_VALUE;
        Arrays.sort(times);
        
        long s = 0;
        long e = (long)times[times.length - 1] * n;
        
        while (s <= e) {
            long mid = (s + e) / 2;
            
            long sum = 0;
            for (int i = 0; i < times.length; i++) {
                sum += mid / times[i];
            }
            
            if (sum < n) {
                s = mid + 1;
            }
            else {
                e = mid - 1;
                answer = Math.min(answer, mid);
            } 
        }
        
        return answer;
    }
}