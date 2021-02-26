import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Programmers {
	static int cnt;
    static boolean[] visited;
    static int[] arr;
    static int[] answer;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] jobs = new int[][] {{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}};
		System.out.print(solution(jobs));
	}
	
	public static int solution(int[][] jobs) {
		int answer = 0;
		int len = jobs.length;
		int time = 0;
		int idx = 0;
		Queue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		
		Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
		
		while (idx < len || !q.isEmpty()) {
			while (idx < len && jobs[idx][0] <= time)
				q.offer(jobs[idx++]);
			
			if (q.isEmpty())
				time = jobs[idx][0];
			else {
				int[] job = q.poll();
				answer += time - job[0] + job[1];
				time += job[1];
			}
		}
		
		return answer / len;
    }
}