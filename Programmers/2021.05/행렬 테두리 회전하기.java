
public class Main {
	static int[][] map;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		int[] answer = solution(6, 6, queries);
		
		for (int i : answer) {
			System.out.print(i + " ");
		}
	}

	public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        map = new int[rows][columns];
        
        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = num++;
            }
        }
        
        for (int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;
            
            answer[i] = rotation(x1, y1, x2, y2);
        }

        return answer;
    }
    
    public static int rotation(int x1, int y1, int x2, int y2) {
    	int tmp = map[x1][y1];
    	int min = tmp;
    	
//         위쪽으로
        for (int i = x1; i < x2; i++) {
            map[i][y1] = map[i + 1][y1];
            min = Math.min(map[i][y1], min);
        }
        
//         왼쪽으로
        for (int j = y1; j < y2; j++) {
            map[x2][j] = map[x2][j + 1];
            min = Math.min(map[x2][j], min);
        }
        
//         아래쪽으로
        for (int i = x2; i > x1; i--) {
            map[i][y2] = map[i - 1][y2];
            min = Math.min(map[i][y2], min);
        } 
        
//         오른쪽으로
        for (int j = y2; j > y1; j--) {
            map[x1][j] = map[x1][j - 1];
            min = Math.min(map[x1][j], min);
        }
        
        map[x1][y1 + 1] = tmp;
        
        return min;
    } 
}