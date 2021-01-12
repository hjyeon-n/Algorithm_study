
public class Programmers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(3));
	}

	public static String solution(int n) {
        String answer = "";
        for (int i = 0; i < n / 2; i++) {
                answer += "¼ö¹Ú";
        }
        
        if (n % 2 != 0) {
            answer += "¼ö";
        }
        
        return answer;
    }
}