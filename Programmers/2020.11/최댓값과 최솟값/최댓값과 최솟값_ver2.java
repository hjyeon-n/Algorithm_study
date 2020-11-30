import java.util.Arrays;
import java.util.stream.Stream;
public class Programmers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("1 2 3 4"));
	}

	public static String solution(String s) {
        String answer = "";
        int[] arr = Stream.of(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        
        Arrays.sort(arr);
        answer = String.valueOf(arr[0]) + " " + String.valueOf(arr[arr.length - 1]);
        
        return answer;
    }
}