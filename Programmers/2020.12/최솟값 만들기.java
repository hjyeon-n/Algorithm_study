import java.util.Arrays;

public class Programmers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1, 4, 2};
		int[] B = {5, 4, 4};

		System.out.println(solution(A, B));
	}

	public static int solution(int []A, int []B)
	{
		int len = B.length;

		Arrays.sort(A);
		Arrays.sort(B);

		int answer = 0;
		for (int i = 0; i < len; i++) {
			answer += A[i] * B[len - i - 1];
		}
		return answer;
	}
}