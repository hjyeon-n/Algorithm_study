import java.util.ArrayList;
import java.util.Arrays;
public class Programmers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5, 9, 7, 10};
		int[] answer = solution(arr, 5);
		
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

	public static int[] solution(int[] arr, int divisor) {
        if (divisor == 1) {
            Arrays.sort(arr);
            return arr;
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                list.add(arr[i]);
            }
        }
        
        if (list.size() == 0) {
            int[] answer = {-1};
            return answer;
        }
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        Arrays.sort(answer);
        return answer;
    }
}