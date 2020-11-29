public class Programmers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("a234"));
	}

	public static boolean solution(String s) {   
		int len = s.length();
		if(len == 4 || len == 6){
			try {
				Integer.parseInt(s);
				return true;
			} catch(NumberFormatException e){
				return false;
			}
		}
		return false;
	}
}