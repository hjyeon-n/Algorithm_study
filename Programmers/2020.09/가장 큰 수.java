import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Programmers {
	static ArrayList<Integer> preorder;
	static ArrayList<Integer> postorder;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {3, 30, 34, 5, 9};
		System.out.println(solution(numbers));
	}
	
	public static String solution(int[] numbers) {
        int len = numbers.length;
        String[] arr = new String[len];
        boolean flag = false;
        String answer = "";
        for (int i = 0; i < len; i++) {
            if (numbers[i] != 0) {
                flag = true;
            }
            arr[i] = String.valueOf(numbers[i]);
        }

        if (!flag) {
            return "0";
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return ((o2 + o1).compareTo(o1 + o2));
            }
        });

        for (int i = 0; i < len; i++) {
            answer += arr[i];
        }

        return answer;
    }
}
