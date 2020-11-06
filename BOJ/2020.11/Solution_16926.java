import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_16926 {
	static int[][] A;
	static int N, M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		A = new int[N + 1][M + 1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < K; i++) {
			rotate();
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
            	sb.append(A[i][j] + " ");
            }
            sb.append("\n");
        }
		System.out.println(sb);
	}
	
	public static void rotate() {
		Location start = new Location(1, 1);
		Location end = new Location(N, M);
		int S = Math.min(N, M) / 2;
		
		for (int k = 0; k < S; k++) {
			int tmp = A[end.x][start.y];
	
	//		위에서 아래로
			for (int i = end.x; i > start.x; i--) {
				A[i][start.x] = A[i - 1][start.x];
			}
			
	//		오른쪽에서 왼쪽으로
			for (int i = start.y; i < end.y; i++) {
				A[start.x][i] = A[start.x][i + 1];
			}
			
	//		아래에서 위로
			for (int i = start.x; i < end.x; i++) {
				A[i][end.y] = A[i + 1][end.y];
			}
			
	//		왼쪽에서 오른쪽으로
			for (int i = end.y; i > start.y; i--) {
				A[end.x][i] = A[end.x][i - 1];
			}
	
			A[end.x][start.y + 1] = tmp;
			
			start = new Location(start.x + 1, start.y + 1);
			end = new Location(end.x - 1, end.y - 1);
		}
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