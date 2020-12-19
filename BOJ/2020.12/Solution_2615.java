import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2615 {
	static int[][] map;
	static int[] node;
	static String[] direction = {"U", "D", "L", "R", "UR", "UL", "DR", "DL"};
	static String[] reverse = {"D", "U", "R", "L", "DL", "DR", "UL", "UR"};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new int[20][20];
		for (int i = 1; i <= 19; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 19; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if (changeTurn(1)) {
			System.out.println("1");
			System.out.println(node[0] + " " + node[1]);
			return;
		}
		
		if (changeTurn(2)) {
			System.out.println("2");
			System.out.println(node[0] + " " + node[1]);
			return;
		}
		
		System.out.println("0");
	}
	
	public static boolean changeTurn(int turn) {
		for (int i = 1; i <= 19; i ++) {
			for (int j = 1; j <= 19; j++) {
				if (map[i][j] == turn) {
					node = new int[] {i, j};
					
					for (int k = 0; k < 8; k++) {
						int revDir = cntDirection(turn, reverse[k]);
						int dir = cntDirection(turn, direction[k]);
						if (revDir + dir + 1 == 5) {
							setNode(reverse[k], i, j);
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	public static int cntDirection(int turn, String direction) {
		int cnt = 0;
		int x = node[0];
		int y = node[1];
		
		while (true) {
			if (direction.equals("U")) {
				if (x - 1 < 1 || map[x - 1][y] != turn) {
					break;
				}
				else {
					x = x - 1;
					cnt++;
				}
			}
			else if (direction.equals("D")) {
				if (x + 1 > 19 || map[x + 1][y] != turn) {
					break;
				}
				else {
					x = x + 1;
					cnt++;
				}
			}
			else if (direction.equals("L")) {
				if (y - 1 < 1 || map[x][y - 1] != turn) {
					break;
				}
				else {
					y = y - 1;
					cnt++;
				}
			}
			else if (direction.equals("R")) {
				if (y + 1 > 19 || map[x][y + 1] != turn) {
					break;
				}
				else {
					y = y + 1;
					cnt++;
				}
			}
			else if (direction.equals("UR")) {
				if (x - 1 < 1 || y + 1 > 19 || map[x - 1][y + 1] != turn) {
					break;
				}
				else {
					x = x - 1;
					y = y + 1;
					cnt++;
				}
			}
			else if (direction.equals("UL")) {
				if (x - 1 < 1 || y - 1 < 1 || map[x - 1][y - 1] != turn) {
					break;
				}
				else {
					x = x - 1;
					y = y - 1;
					cnt++;
				}
			}
			else if (direction.equals("DR")) {
				if (x + 1 > 19 || y + 1 > 19 || map[x + 1][y + 1] != turn) {
					break;
				}
				else {
					x = x + 1;
					y = y + 1;
					cnt++;
				}
			}
			else if (direction.equals("DL")) {
				if (x + 1 > 19 || y - 1 < 1 || map[x + 1][y - 1] != turn) {
					break;
				}
				else {
					x = x + 1;
					y = y - 1;
					cnt++;
				}
			}
		}
		
		return cnt;
	}
	
	public static void setNode (String dir, int x, int y) {
		if (dir.equals("U")) {
			node = new int[]{x - 4 , y};
		}
		else if (dir.equals("D")) {
			node = new int[] {x, y};
		}
		else if (dir.equals("R")) {
			node = new int[] {x, y};
		}
		else if (dir.equals("L")) {
			node = new int[] {x, y - 4};
		}
		else if (dir.equals("UR")) {
			node = new int[] {x - 4, y};
		}
		else if (dir.equals("UL")) {
			node = new int[] {x - 4, y - 4};
		}
		else if (dir.equals("DR")) {
			node = new int[] {x, y};
		}
		else if (dir.equals("DL")) {
			node = new int[] {x + 4, y - 4};
		}
	}
}