public class Programmers {
	static int cnt;
    static boolean[] visited;
    static int[] arr;
    static int[] answer;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.print(solution(121));
	}
	
	public static long solution(long n) {
        long answer = 0;
        while (answer * answer <= n) {
            if (answer * answer == n) {
                answer = (answer + 1) * (answer + 1);
                return answer;
            }
            answer++;
        } 
        return -1;
    }
}