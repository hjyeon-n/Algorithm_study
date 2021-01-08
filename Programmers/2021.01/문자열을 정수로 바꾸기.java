public class Programmers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("-1234"));
	}

	public static int solution(String s) {
        int answer = 0;
        if (s.charAt(0) == '+') {
            answer = Integer.parseInt(s.substring(1));    
        }
        else if (s.charAt(0) == '-') {
            answer = Integer.parseInt(s.substring(1)) * -1;  
        }
        else {
            answer = Integer.parseInt(s);
        }
        return answer;
    }
}