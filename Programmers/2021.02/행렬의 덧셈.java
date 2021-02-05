public class Programmers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] arr1 = {{1, 2}, {2, 3}};
		int[][] arr2 = {{3, 4}, {5, 6}};
		
		int[][] answer = solution(arr1, arr2);
		
		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < answer[0].length; j++) {
				System.out.print(answer[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	public static int[][] solution(int[][] arr1, int[][] arr2) {
        int height = arr1.length;
        int width = arr1[0].length;
    
        int[][] answer = new int[height][width];
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }
}