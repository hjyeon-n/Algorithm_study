public class Programmers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(solution(15));
	}
	
	public static int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = i; j <= n; j++) {
                sum += j;
                
                if (sum == n) {
                    answer++;
                }
                
                if (sum > n) {
                    break;
                }
            }
        }
        
        return answer;
    }
}