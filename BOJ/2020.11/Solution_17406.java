import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_17406 {
	static int[][] A, copyA;
	static Location start, end;
	static int min, N, M;
	static boolean[] visited;
	static int[] arr;
	static Rotate[] rotateArr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		A = new int[N + 1][M + 1];
		min = Integer.MAX_VALUE;
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		copyA = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                copyA[i][j] = A[i][j];  
            }
        }
		
		rotateArr = new Rotate[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			rotateArr[i] = new Rotate(r, c, s);
		}
		
//		모든 회전의 경우 생각하기
		visited = new boolean[K];
		arr = new int[K];
		
		dfs(K, K, 0);
		
		System.out.println(min);
	}
	
	public static void rotate(Rotate rotate) {
		int r = rotate.r;
		int c = rotate.c;
		int s = rotate.s;
		
		start = new Location(r - s, c - s);
		end = new Location(r + s, c + s);
		
		while (start.x != end.x) {
			int tmp = A[start.x][start.y];
			
//			아래에서 위로
			for (int i = start.x; i < end.x; i++) {
				A[i][start.y] = A[i + 1][start.y];
			}
			
//			오른쪽에서 왼쪽으로
			for (int i = start.y; i < end.y; i++) {
				A[end.x][i] = A[end.x][i + 1];
			}
			
//			위에서 아래로
			for (int i = end.x; i > start.x; i--) {
				A[i][end.y] = A[i - 1][end.y];
			}
			
//			왼쪽에서 오른쪽으로
			for (int i = end.y; i > start.y; i--) {
				A[start.x][i] = A[start.x][i - 1];
			}
			
			A[start.x][start.y + 1] = tmp;
			
			start = new Location(start.x + 1, start.y + 1);
			end = new Location(end.x - 1, end.y - 1);
		}
	}
	
	private static void dfs(int n, int m, int depth) {
		if (depth == m) {
			for (int i = 0; i < m; i++) {
				rotate(rotateArr[arr[i] - 1]);
			}
			getMin();
			
//			다시 원본으로 돌려놓기
			for(int i = 1; i <= N; i++) {
	            for(int j = 1; j <= M; j++) {
	                A[i][j] = copyA[i][j];  
	            }
	        }
			return;
		}
	 
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;	
				arr[depth] = i + 1;	
				dfs(n, m, depth + 1);	
				visited[i] = false;
			}
		}
	}
	
	public static void getMin() {
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j <= M; j++) {
				sum += A[i][j];
			}
			min = Math.min(min, sum);
		}
	}
}

class Location {
	int x;
	int y;
	
	public Location (int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Rotate {
	int r;
	int c;
	int s;
	
	public Rotate (int r, int c, int s) {
		this.r = r;
		this.c = c;
		this.s = s;
	}
}