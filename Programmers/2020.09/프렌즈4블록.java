import java.util.LinkedList;
import java.util.Queue;

public class Programmers {
	static String[][] map;
	static int[][] block;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] board = {
				 "AAAA", "DDDD", "BCDF", "DFFC", "AFFD", "CDEF", "DAAD", "BAAD", "CCCC"};
		System.out.println(solution(9, 4, board));
	}

	public static int solution(int m, int n, String[] board) {
		map = new String[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = String.valueOf(board[i].charAt(j));
			}
		}
		int blockCnt = 0;
		while (true) {
			if (countBlock(m, n, map) == 0) {
				break;
			}
			else {
				map = moveBlock(m, n, map);
			}
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j].equals("*")) {
					blockCnt++;
				}
			}
		}
        return blockCnt;
    }
	
//	블럭 개수를 세는 함수
	public static int countBlock(int m, int n, String[][] map) {
		block = new int[m][n];
		int cnt = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				String str = map[i][j];
				if (str.equals("*")) {
					continue;
				}
				if(i + 1 < m && j + 1 < n){
					if (map[i + 1][j].equals(str) && map[i][j + 1].equals(str)
							&& map[i + 1][j + 1].equals(str)){
						block[i][j] = 1;
						block[i + 1][j] = 1;
						block[i + 1][j + 1] = 1;
						block[i][j + 1] = 1;
						cnt++;
					}
				}
			}
		}
		return cnt;
	}
	
//	블럭을 옮기는 함수
	public static String[][] moveBlock(int m, int n, String[][] map) {
		for (int i = 0; i < n; i++) {
			Queue<Integer> zero = new LinkedList<Integer>();
			for (int j = m - 1; j >= 0; j--) {
				if (block[j][i] == 0) {
					zero.add(j);
				}
			}
			
			int j = m - 1;
			while(!zero.isEmpty()) {
				int x = zero.poll();
				map[j--][i] = map[x][i];
			}
			
			while (j >= 0) {
				map[j--][i] = "*";
			}
		}
		return map;
	}
}
