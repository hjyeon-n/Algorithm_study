
public class Programmers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(626331));
	}

	public static int solution(int num) {
        long n = (long) num;
        int answer = 0;
        
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            }
            else {
                n = n * 3 + 1;
            }
            answer++;
            
            if (answer > 500) {
                return -1;
            }
        }
        
        return answer;
    }
}