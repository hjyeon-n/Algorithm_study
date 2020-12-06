public class Programmers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(3, 5));
	}

	public static long solution(int a, int b) {
        long answer = 0;
        int end = Math.max(a, b);
        int start = Math.min(a, b);
        
        for (int i = start; i <= end; i++) {
            answer += i;
        }
        return answer;
    }
}