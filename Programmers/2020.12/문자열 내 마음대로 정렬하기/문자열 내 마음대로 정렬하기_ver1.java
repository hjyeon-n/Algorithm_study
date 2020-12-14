import java.util.Arrays;
import java.util.Comparator;

public class Programmers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strings = {"sun", "bed", "car"};
		String[] answer = solution(strings, 1);
		
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

	public static String[] solution(String[] strings, int n) {
		Arrays.sort(strings);
		
		Arrays.sort(strings, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int a = o1.charAt(n);
				int b = o2.charAt(n);
				if (a > b) {
					return 1;
				}
				if (a < b) {
					return -1;
				}
				return 0;	
			}
		});
		
		return strings;
	}
}