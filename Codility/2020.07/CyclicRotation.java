public class CyclicRotation {
	public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
		
		if (A.length == 0) {
			return A;
		}
		
		if (K == 0 || K == A.length || K % A.length == 0) {
			return A;
		}
		
		for (int i = 0; i < K; i++) {
			int tmp = A[A.length - 1];
			for (int j = A.length - 2; j >= 0; j--) {
				A[j + 1] = A[j];
			}
			A[0] = tmp;
		}
		return A;
    }
}