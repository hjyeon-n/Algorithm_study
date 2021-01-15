import java.util.ArrayList;

public class Programmers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4, 3, 2, 1};
		int[] answer = solution(arr);
		
		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}

	public static int[] solution(int[] arr) {
        int min = 12345678;
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }
        
        for (int i = 0; i < arr.length; i++) {
        	if (arr[i] != min) {
        		list.add(arr[i]);
        	}
        }
        
        if (list.size() <= 0) {
            return new int[] {-1};
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}