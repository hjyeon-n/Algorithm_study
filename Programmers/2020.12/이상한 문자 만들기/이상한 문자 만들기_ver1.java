public class Programmers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("try hello world"));
	}

	public static String solution(String s) {
		String answer = "";
		int idx = 0;
		for (int i = 0; i < s.length(); i++) {
			if (String.valueOf(s.charAt(i)).equals(" ")) {
				idx = 0;
				answer += " ";
			}
			else {
				if (idx % 2 == 0) {
					answer += String.valueOf(s.charAt(i)).toUpperCase();
				}
				else {
					answer += String.valueOf(s.charAt(i)).toLowerCase();
				}
				idx++;
			}
		}
		return answer;
	}
}