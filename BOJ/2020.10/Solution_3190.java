import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		
		int K = Integer.parseInt(br.readLine());

//		��� ��ġ
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 2;
		}
		
		int L = Integer.parseInt(br.readLine());
		Queue<Command> queue = new LinkedList<Command>();
		
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			String c = st.nextToken();
			queue.add(new Command(x, c));
		}
		
		Deque<Location> deque = new ArrayDeque<Location>();
		int cnt = 0;
		map[1][1] = 1;
		deque.add(new Location(1, 1));
		String direction = "D";
		int x = 1;
		int y = 1;
		
		while(true) {
			if (!queue.isEmpty() && cnt == queue.peek().x) {
				String command = queue.poll().c;
				
				if (direction.equals("D") && command.equals("D")) {
					direction = "B";
				}
				else if (direction.equals("D") && command.equals("L")) {
					direction = "U";
				}
				else if (direction.equals("B") && command.equals("D")) {
					direction = "L";
				}
				else if (direction.equals("B") && command.equals("L")) {
					direction = "D";
				}
				else if (direction.equals("L") && command.equals("D")) {
					direction = "U";
				}
				else if (direction.equals("L") && command.equals("L")) {
					direction = "B";
				}
				else {
					direction = command;
				}
			}
			
			int nx = x;
			int ny = y;
			if (direction.equals("D")) {
				ny = y + 1;
			}
			else if (direction.equals("L")) {
				ny = y - 1;
			}
			else if (direction.equals("U")) {
				nx = x - 1;
			}
			else if (direction.equals("B")) {
				nx = x + 1;
			}
			
			cnt++;
			if (nx >= 1 && nx <= N && ny >= 1 && ny <= N) {
//				���� ���� -> ���� ��!
				if(map[nx][ny] == 1) {
					break;
				}
//				����� ������ ��
				else if (map[nx][ny] == 2) {
					deque.add(new Location(nx, ny));
					map[nx][ny] = 1;
				}
//				�� ĭ
				else {
					map[nx][ny] = 1;
					Location loc = deque.pollFirst();
					map[loc.x][loc.y] = 0;
					deque.add(new Location(nx, ny));
				}
				x = nx;
				y = ny;
			}
			else {
//				���� �ε��� -> ���� ��!
				break;
			}
		}
		System.out.println(cnt);
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

class Command {
	int x;
	String c;
	
	public Command(int x, String c) {
		this.x = x;
		this.c = c;
	}
}