class Programmers {
	public static void main(String[] args) {
		long[] answer = solution(2, 5);
		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}

	public static long[] solution(int x, int n) {
        long[] answer = new long[n];
        long nx = x;
        for (int i = 0; i < n; i++) {
            answer[i] = nx * (i + 1);
        }
        return answer;
    }
}
