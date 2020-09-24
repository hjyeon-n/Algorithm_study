import java.util.ArrayList;
import java.util.Arrays;

public class Programmers {
	static ArrayList<Integer> preorder;
	static ArrayList<Integer> postorder;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		solution(arr, commands);
	}
	
	public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int cnt = 0;
        for (int i = 0; i < commands.length; i++) {
            int[] arr = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(arr);
            answer[cnt++] = arr[commands[i][2] - 1];
        }
        return answer;
    }
}
