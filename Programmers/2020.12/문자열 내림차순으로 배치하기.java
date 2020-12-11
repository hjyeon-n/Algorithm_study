import java.util.Arrays;
import java.util.Collections;

public class Programmers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("Zbcdefg"));
	}

	public static String solution(String s) {
        String answer = "";
        int size = s.length();
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int)s.charAt(i);
        }

        Arrays.sort(arr, Collections.reverseOrder());

        for (int i = 0; i < size; i++) {
            answer += String.valueOf((char)(int)arr[i]);
        }
        return answer;
    }
}