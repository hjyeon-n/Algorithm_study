import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Solution_15683 {
	static int[][] visited;
	static int N, M;
	static ArrayList<Node> list;
	static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		list = new ArrayList<Node>();
		answer = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] >= 1 && map[i][j] <= 5) {
					list.add(new Node(i, j, map[i][j]));
				}
			}
		}
		
		solution(0, map);
		
		System.out.println(answer);
	}
	
	public static void solution(int idx, int[][] prev) {
		if (idx == list.size()) {
			int cnt = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (prev[i][j] == 0) {
						cnt++;
					}
				}
			}
			
			answer = Math.min(answer, cnt);
			return;
		}
		else {
			Node node = list.get(idx);
			int x = node.x;
			int y = node.y;
			int val = node.val;
			
			switch(val) {
				case 1:
					for (int k = 0; k < 4; k++) {
						int[][] tmp = copy(prev);
						traversal(tmp, x, y, k);
						solution(idx + 1, tmp);
					}
					break;
					
				case 2:
					for (int k = 0; k < 2; k++) {
						int[][] tmp = copy(prev);
						traversal(tmp, x, y, k);
						traversal(tmp, x, y, k + 2);
						solution(idx + 1, tmp);
					}
					break;
					
				case 3:
					for (int k = 0; k < 4; k++) {
						int[][] tmp = copy(prev);
						traversal(tmp, x, y, k);
						traversal(tmp, x, y, (k + 1) % 4);
						solution(idx + 1, tmp);
					}
					break;
					
				case 4:
					for (int k = 0; k < 4; k++) {
						int[][] tmp = copy(prev);
						traversal(tmp, x, y, k);
						traversal(tmp, x, y, (k + 1) % 4);
						traversal(tmp, x, y, (k + 2) % 4);
						solution(idx + 1, tmp);
					}
					break;
					
				case 5:
					int[][] tmp = copy(prev);
					traversal(tmp, x, y, 0);
					traversal(tmp, x, y, 1);
					traversal(tmp, x, y, 2);
					traversal(tmp, x, y, 3);
					solution(idx + 1, tmp);
					break;
			}
		}
	}
	
	public static void traversal(int[][] map, int x, int y, int dir) {
		switch(dir) {
			case 0:
	//			왼쪽
				for (int j = y; j >= 0; j--) {
					if (map[x][j] == 6) {
						break;
					}
					map[x][j] = 7;
				}
				break;
				
			case 1:
//				위쪽
				for (int i = x; i >= 0; i--) {
					if (map[i][y] == 6) {
						break;
					}
					map[i][y] = 7;
				}
				break;
		
			case 2:
//				오른쪽
				for (int j = y; j < M; j++) {
					if (map[x][j] == 6) {
						break;
					}
					map[x][j] = 7;
				}
				break;
				
			case 3: 
//				아래쪽
				for (int i = x; i < N; i++) {
					if (map[i][y] == 6) {
						break;
					}
					map[i][y] = 7;
				}
				break;
		}
	}
	
	public static int[][] copy(int[][] map) {
		int[][] newMap = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newMap[i][j] = map[i][j];
			}
		}
		return newMap;
	}
}

class Node {
	int x;
	int y;
	int val;
	
	public Node(int x, int y, int val) {
		this.x = x;
		this.y = y;
		this.val = val;
	}
}