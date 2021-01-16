
public class Programmers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = {"Jane", "Kim"};
		
		System.out.print(solution(arr));
	}

	public static String solution(String[] seoul) {
        int idx = 0;
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                idx = i;
            }
        }
        String answer = "김서방은 " + idx + "에 있다";
        return answer;
    }
}