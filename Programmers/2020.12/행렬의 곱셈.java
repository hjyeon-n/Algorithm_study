
public class Programmers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
//		int[][] arr2 = {{3, 3}, {3, 3}};
		
		int[][] arr1 = {{1, 2, 3}, {4, 5, 6}};
		int[][] arr2 = {{1, 4}, {2, 5}, {3, 6}};

		int[][] answer = solution(arr1, arr2);

		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < answer[0].length; j++) {
				System.out.print(answer[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = new int[arr1.length][arr2[0].length];

		for (int k = 0; k < arr1.length; k++) {
			for (int i = 0; i < arr2[0].length; i++) {
				for (int j = 0; j < arr2.length; j++) {
					answer[k][i] += arr1[k][j] * arr2[j][i]; 
				}
			}
		}
		return answer;
	}
}