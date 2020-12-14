import java.util.Arrays;

public class Programmers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("Zbcdefg"));
	}

	public static String solution(String s) {
		char[] sol = s.toCharArray();
	    Arrays.sort(sol);
	    return new StringBuilder(new String(sol)).reverse().toString();
    }
}