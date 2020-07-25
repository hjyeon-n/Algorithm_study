import java.util.Arrays;

class MissingInteger {
	public int solution(int[] A) {
		// write your code in Java SE 8

		int answer = 1;
		Arrays.sort(A);

		for (int i = 0; i < A.length; i++) {
			if (A[i] < 0) {
				continue;
			}
			if (A[i] > 0) {
				if (A[i] <= answer) {
					answer = A[i] + 1;
				}
				if (A[i] > answer) {
					continue;
				}
			}
		}
		return answer;
	}
}
