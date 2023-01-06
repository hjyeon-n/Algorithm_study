import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_18405 {

	static int N, K;
	static int[][] map;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static PriorityQueue<Node> pq;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N + 1][N + 1];
		
		pq = new PriorityQueue<Node>(Comparator.comparing(Node::getT).thenComparing(Node::getS));
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int val = Integer.parseInt(st.nextToken());
				map[i][j] = val;
				
				if (val != 0) {
					pq.offer(new Node(i, j, val, 0));
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		spread(S);
		System.out.println(map[X][Y]);
	}
	
	public static void spread(int S) {
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			
//			요구하는 시간이 이미 끝났을 경우 더이상 탐색할 필요가 없음
			if (node.getT() == S) {
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = node.getX() + dx[i];
				int ny = node.getY() + dy[i];
				
				if (nx >= 1 && nx <= N && ny >= 1 && ny <= N) {
					if (map[nx][ny] == 0) {
						map[nx][ny] = node.getS();
						pq.add(new Node(nx, ny, node.getS(), node.getT() + 1));
					}
				}
			}
		}
	}
}

class Node {
	private int x;
	private int y;
	private int s;
	private int t;
	
	public Node(int x, int y, int s, int t) {
		this.x = x;
		this.y = y;
		this.s = s;
		this.t = t;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getS() {
		return s;
	}
	
	public int getT() {
		return t;
	}
}