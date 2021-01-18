
public class Programmers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(solution(123));
	}

	public static int solution(int n) {
        int answer = 0;

        while (n > 0) {
            answer += n % 10;
            n = n / 10;
        }
        return answer;
    }
}