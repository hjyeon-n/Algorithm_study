
public class Programmers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("01033334444"));
	}

	public static String solution(String phone_number) {
        int rep = phone_number.length() - 4;
        String answer = "";
        
        for (int i = 0; i < rep; i++) {
            answer += "*";
        }
        
        answer += phone_number.substring(rep);
        
        return answer;
    }
}