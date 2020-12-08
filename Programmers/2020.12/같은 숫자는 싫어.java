import java.util.ArrayList;

public class Programmers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,1,3,3,0,1,1};
		System.out.println(solution(arr));
	}

	public static int[] solution(int []arr) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		list.add(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			if (list.get(list.size() - 1) != arr[i]) {
				list.add(arr[i]);
			}
		}

		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}
}