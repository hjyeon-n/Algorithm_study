import java.util.ArrayList;

class Programmers {
	public static void main(String[] args) {
		int[] answer = solution(3, 5);
		
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

	public static int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> list = new ArrayList<Integer>();
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            list.add(i);
            factorial *= i;
        }

        int i = 0;
        long remain = k - 1;

        while (i < n) {
            factorial = factorial / (n - i);
            long value = remain / factorial;
            answer[i++] = list.get((int)value);
            list.remove((int)value);
            remain = remain % factorial;
        }
        return answer;
    }
}
