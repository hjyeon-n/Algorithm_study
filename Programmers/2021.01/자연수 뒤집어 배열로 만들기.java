
public class Programmers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] answer = solution(12345);
		
		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i]);
		}
	}

	public static int[] solution(long n) {
        String str = String.valueOf(n);
        int len = str.length();
        int[] answer = new int[len];
        
        for (int i = 0; i < len; i++) {
            answer[len - i - 1] = str.charAt(i) - '0';
        }
        
        return answer;
    }
}