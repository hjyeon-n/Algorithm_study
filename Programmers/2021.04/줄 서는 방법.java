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
        long fac = 1;
        int idx = 0;
        
        for (int i = 1; i <= n; i++) {
            list.add(i);
            fac *= i;
        }
        
        k--;

        while (n > 0) {
            fac /= n--;
            int val = (int)(k / fac);
            answer[idx++] = list.get(val);
            list.remove(val);
            k %= fac;
        }
        
        return answer;
    }
}
