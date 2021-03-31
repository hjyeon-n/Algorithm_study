import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_14891 {
	static int[][] gear;
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		gear = new int[4][8];

		for (int i = 0; i < 4; i++) {
			String str = br.readLine();

			for (int j = 0; j < str.length(); j++) {
				gear[i][j] = str.charAt(j) - '0';
			}
		}

		int K = Integer.parseInt(br.readLine());

		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int num = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken());

			int before = num - 1;
			int after = num + 1;

			int val1 = gear[num][6];
			int val2 = gear[num][2];
			
//			입력 받은 톱니바퀴 움직이기
			rotation(num, dir);
			
			boolean flag = true;
			int tmp_dir = dir;
			
			while (before > -1) {
				if (val1 != gear[before][2] && flag) {
					flag = true;
					tmp_dir *= -1;
				}
				else {
					flag = false;
				}
				
				val1 = gear[before][6];
				if (flag) {
					rotation(before, tmp_dir);
				}
				
				before--;
			}
			
			flag = true;
			tmp_dir = dir;
			
			while (after < 4) {
				if (val2 != gear[after][6] && flag) {
					flag = true;
					tmp_dir *= -1;
				}
				else {
					flag = false;
				}
				
				val2 = gear[after][2];
				if (flag) {
					rotation(after, tmp_dir);
				}
				
				after++;
			}
		}

		int answer = 0;
		for (int i = 0; i < 4; i++) {
			if (gear[i][0] == 1) {
				answer += Math.pow(2, i);
			}
		}

		System.out.println(answer);
	}

	public static void rotation(int num, int dir) {
		int[] tmp = new int[8];

		for (int i = 0; i < 8; i++) {
			tmp[i] = gear[num][i];
		}

		if (dir == 1) {
			gear[num][0] = gear[num][7];

			for (int i = 1; i < 8; i++) {
				gear[num][i] = tmp[i - 1];
			}
		}
		else {
			gear[num][7] = gear[num][0];

			for (int i = 6; i >= 0; i--) {
				gear[num][i] = tmp[i + 1];
			}
		}
	}
}
