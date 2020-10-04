import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int[] command;
	static int[] dice;
	static int N, M;
	static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { 1, -1, 0, 0 };
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		command = new int[K];
		for (int i = 0; i < K; i++) {
			command[i] = Integer.parseInt(st.nextToken());
		}
		
		dice = new int[7];
		rollDice(x, y);
	}
	
	public static void rollDice(int x, int y) {
		for (int i = 0; i < command.length; i++) {
			int[] tmp = dice.clone();
			int comm = command[i];
			
			int nx = x + dx[comm - 1];
            int ny = y + dy[comm - 1];
			
            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
				if (comm == 1) {
					dice[1] = tmp[4];
		            dice[3] = tmp[1];
		            dice[4] = tmp[6];
		            dice[6] = tmp[3];
				}
				else if (comm == 2) {
					dice[1] = tmp[3];
		            dice[3] = tmp[6];
		            dice[4] = tmp[1];
		            dice[6] = tmp[4];
				}
				else if (comm == 3) {
					dice[1] = tmp[5];
		            dice[2] = tmp[1];
		            dice[5] = tmp[6];
		            dice[6] = tmp[2];
				}
				else {
					dice[1] = tmp[2];
		            dice[2] = tmp[6];
		            dice[5] = tmp[1];
		            dice[6] = tmp[5];
				}
			
				if (map[nx][ny] == 0) {
					map[nx][ny] = dice[6];
				}
				else {
					dice[6] = map[nx][ny];
                    map[nx][ny] = 0;
				}
				
				System.out.println(dice[1]);
				x = nx;
				y = ny;
			}
		}
	}
} 