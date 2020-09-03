import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class 14889_ver2 {
	static int[] start, link;
	static int n, m; 
	static int min;
	static int s[][];
	static boolean[] select;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		min = Integer.MAX_VALUE;
		
		n = Integer.parseInt(st.nextToken());
		m = n / 2;
		
		s = new int[n][n];
		select = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				s[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		start = new int[m];
		link = new int[m];
		comb(0, 0);
		System.out.println(min);
	}
	
	private static void comb(int depth, int idx) {
		if (depth == m) {
			int sCnt = 0;
			int lCnt = 0;
			
			for (int i = 0; i < n; i++) {
				if(select[i]) {
					start[sCnt++] = i; // 선택된 사람들은 스타트팀에 넣고
				}
				else {
					link[lCnt++] = i; // 나머지 사람들은 링크팀에 넣기
				}
			}
			min = Math.min(min, Math.abs(cal(start) - cal(link))); // 두 팀의 능력치 합의 차이 구하기
			return;
		}
	 
		for (int i = idx; i < n; i++) {
			if(select[i]) {
				continue;
			}
			select[i] = true;
			comb(depth + 1, i);
			select[i] = false;
		}
	}
	
	public static int cal(int[] arr) {
		int sum = 0, x = 0, y = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				x = arr[i]; 
				y = arr[j];
				sum += s[x][y] + s[y][x];
			}
		}
		return sum;
	}
}