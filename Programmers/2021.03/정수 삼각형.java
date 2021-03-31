class Programmers {
	public static void main(String[] args) {
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		System.out.println(solution(triangle));
	}

	public static int solution(int[][] triangle) {
        int h = triangle.length;
        int answer = -1;
        
        for (int i = 1; i < h; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                	triangle[i][j] += triangle[i - 1][j];
                }
                else if (i == j) {
                	triangle[i][j] += triangle[i - 1][j - 1];
                }
                else {
                	triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
                }
                
                answer = Math.max(answer, triangle[i][j]);
            }
        }
        
        return answer;
    }
}
