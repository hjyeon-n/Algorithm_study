import java.util.Arrays;
public class Programmers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("1 2 3 4"));
	}

	public static String solution(String s) {
        String answer = "";
        String[] strArr = s.split(" ");
        int[] arr = new int[strArr.length];
        
        for (int i = 0; i < strArr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        } 
        
        Arrays.sort(arr);
        answer = String.valueOf(arr[0]) + " " + String.valueOf(arr[arr.length - 1]);
        
        return answer;
    }
}