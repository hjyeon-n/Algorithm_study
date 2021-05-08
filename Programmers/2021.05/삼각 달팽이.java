
public class Main {
	static int[] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] answer = solution(4);
		
		for (int i : answer) {
			System.out.print(i + " ");
		}
	}

	public static int[] solution(int n) {
        int[] answer = new int[(n * (n + 1)) / 2];
        int[][] matrix = new int[n][n];
        
        int x = -1, y = 0;
        int num = 1;
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) {
                    x++;
                }
                else if (i % 3 == 1) {
                    y++;
                }
                else {
                    x--;
                    y--;
                }
                
                matrix[x][y] = num++;
            }
        }
        
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    break;
                }
                answer[idx++] = matrix[i][j];
            }
        }
        
        return answer;
    }
}