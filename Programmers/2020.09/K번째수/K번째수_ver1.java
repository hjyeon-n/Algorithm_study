import java.util.ArrayList;
import java.util.Collections;

public class Programmers {
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
            int start = commands[i][0];
            int end = commands[i][1];
            int k = commands[i][2];
            
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int j = start - 1; j < end; j++) {
                list.add(array[j]);
            }
            Collections.sort(list);
            answer[cnt++] = list.get(k - 1);
        }
        return answer;
    }
}
