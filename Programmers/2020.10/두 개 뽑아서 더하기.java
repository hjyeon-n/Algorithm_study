import java.util.ArrayList;
import java.util.Collections;

public class Programmers {
	static boolean[] visited;
	public static void main(String[] args) {
    	// TODO Auto-generated method stub
    	int[] numbers = {2, 1, 3, 4, 1};
    	int[] answer = solution(numbers);
    	
    	for (int i = 0; i < answer.length; i++) {
    		System.out.print(answer[i] + " ");
    	}
    }
    
	public static int[] solution(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int len = numbers.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int sum = numbers[i] + numbers[j];
                if (!list.contains(sum)) {
                    list.add(sum);
                }
            }
        }

        Collections.sort(list);

        len = list.size();
        int[] answer = new int[len];

        for (int i = 0; i < len; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}