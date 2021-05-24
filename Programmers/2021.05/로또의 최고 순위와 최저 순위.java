import java.util.ArrayList;

public class Main {
	public static void main(String[] args){
		// TODO Auto-generated method stub
		int[] lottos = {44, 1, 0, 0, 31, 25};
		int[] win_nums = {31, 10, 45, 1, 6, 19};
		System.out.println(solution(lottos, win_nums));
	}
	
	public static int[] solution(int[] lottos, int[] win_nums) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < win_nums.length; i++) {
            list.add(win_nums[i]);
        }

        int zero = 0;
        int match = 0;
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                zero++;
            }

            if (list.contains(lottos[i])) {
                match++;
            }
        }

        int max = zero + match;
        int min = match;

        if (min == 0) {
            min = 1;
        }

        if (max == 0) {
            max = 1;
        }

        int[] answer = new int[]{7 - max, 7 - min};
        return answer;
    }
}