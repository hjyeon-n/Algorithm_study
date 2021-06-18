
public class Main {
	public static void main(String[] args){
		// TODO Auto-generated method stub
		System.out.println(solution(13, 17));
	}

	public static int solution(int left, int right) {
        int answer = 0;
        
        for (int i = left; i <= right; i++) {
            if (divisor(i) % 2 == 0) {
                answer += i;
            }
            else {
                answer -= i;
            }
        }
        return answer;
    }
	
	public static int divisor(int n) {
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                cnt++;
            }
        }
        return cnt;
    } 
}