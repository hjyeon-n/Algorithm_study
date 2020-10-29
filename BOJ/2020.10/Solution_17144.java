import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Solution_17144 {
	static int[][] map;
	static int R, C;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[] cleaner;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		cleaner = new int[2];
		
//		�Է� �κ�
//		����û����� -1
		int cleaner_idx = 0;;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == -1) {
					cleaner[cleaner_idx++] = i;
				}
			}
		}
		
		for (int i = 0; i < T; i++) {
//			�̼����� Ȯ��
			spreadDust();
			
//			�̼����� ��ȭ
			cleanDustA(cleaner[0]);
			cleanDustB(cleaner[1]);
		}
		
//		���� �̼����� �� ����
		int answer = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0) {
					answer += map[i][j];
				}
			}
		}
		System.out.println(answer);
	}
	
	public static void spreadDust() {
		int[][] tmp = new int[R][C];
		Queue<Location> queue = new LinkedList<Location>();
		
//		Ȯ���ų �̼������� ť�� �ֱ�
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0) {
					queue.add(new Location(i, j));
				}
			}
		}
		
		while(!queue.isEmpty()) {
			Location loc = queue.poll();
			int x = loc.x;
			int y = loc.y;
			
			int cnt = 0;
			if (map[x][y] >= 5) {
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
						if (map[nx][ny] != -1) {
							tmp[nx][ny] += map[x][y] / 5;
							cnt++;
						}
					}
				}
				tmp[x][y] -= (map[x][y] / 5) * cnt; 
			}
		}
		
//		������ / ���Һи�ŭ �����ֱ�
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] += tmp[i][j];
			}
		}
	}
	
//	�ݽð� ����
	public static void cleanDustA(int idx) {
//		�Ʒ��� �̵�
		for (int i = idx - 1; i > 0; i--) {
			map[i][0] = map[i - 1][0];
		}
		
//		�������� �̵�
		for (int i = 0; i < C - 1; i++) {
			map[0][i] = map[0][i + 1];
		}
		
//		���� �̵�
		for (int i = 0; i < idx; i++) {
			map[i][C - 1] = map[i + 1][C - 1];
		}
		
//		���������� �̵�
		for (int i = C - 1; i > 1; i--) {
			map[idx][i] = map[idx][i - 1];
		}
		
		map[idx][1] = 0;
	}
	
//	�ð� ����
	public static void cleanDustB(int idx) {
//		���� �̵�
		for (int i = idx + 1; i < R - 1; i++) {
			map[i][0] = map[i + 1][0];
		}
		
//		�������� �̵�
		for (int i = 0; i < C - 1; i++) {
			map[R - 1][i] = map[R - 1][i + 1];
		}
		
//		�Ʒ��� �̵�
		for (int i = R - 1; i > idx; i--) {
			map[i][C - 1] = map[i - 1][C - 1];
		}
		
//		���������� �̵�
		for (int i = C - 1; i > 1; i--) {
			map[idx][i] = map[idx][i - 1];
		}
		
		map[idx][1] = 0;
	}
}

class Location {
	int x;
	int y;
	
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}