import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2578 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] map = new int[5][5];
		boolean[][] checkBoard = new boolean[5][5];
		
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				cnt++;
				int call = Integer.parseInt(st.nextToken());
				
				for (int n = 0; n < 5; n++) {
					for (int m = 0; m < 5; m++) {
						if (map[n][m] == call) {
							checkBoard[n][m] = true;
							
							if (checkBingo(checkBoard)) {
								System.out.println(cnt);
								return;
							}
						}
					}
				}
			}
		}
	}
	
	public static boolean checkBingo(boolean[][] checkBoard) {
		int bingo = 0;
		
//		가로
		for (int i = 0; i < 5; i++) {
			int rslt = 0;
			for (int j = 0; j < 5; j++) {
				if (checkBoard[i][j]) {
					rslt++;
				}
				else {
					break;
				}
			}
			
			if (rslt == 5) {
				bingo++;
			}
		}
		
//		세로
		for (int i = 0; i < 5; i++) {
			int rslt = 0;
			for (int j = 0; j < 5; j++) {
				if (checkBoard[j][i]) {
					rslt++;
				}
				else {
					break;
				}
			}
			
			if (rslt == 5) {
				bingo++;
			}
		}
		
//		오른쪽 대각선
		for (int i = 0; i < 1; i++) {
			int rslt = 0;
			for (int j = 0; j < 5; j++) {
				if (checkBoard[j][j]) {
					rslt++;
				}
				else {
					break;
				}
			}
			
			if (rslt == 5) {
				bingo++;
			}
		}
		
//		왼쪽 대각선
		for (int i = 0; i < 1; i++) {
			int rslt = 0;
			for (int j = 0; j < 5; j++) {
				if (checkBoard[j][4 - j]) {
					rslt++;
				}
				else {
					break;
				}
			}
			
			if (rslt == 5) {
				bingo++;
			}
		}
		
		if (bingo >= 3) {
			return true;
		}
		return false;
	}
}