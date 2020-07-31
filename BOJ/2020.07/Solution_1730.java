import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[][] map = new char[n][n];
		
		String str = br.readLine();
		char[] direction = new char[str.length()];
		
		for (int i = 0; i < str.length(); i++) {
			direction[i] = str.charAt(i);
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = '.';
			}
		}
		
		int x = 0;
		int y = 0;
		for (int i = 0; i < direction.length; i++) {
			switch(direction[i]) {
				case 'U':
					if (x - 1 >= 0) {
						if (map[x][y] == '-') {
							map[x][y] = '+';
						}
						else if (map[x][y] == '.'){
							map[x][y] = '|';
						}
						x--;
						if (map[x][y] == '-') {
							map[x][y] = '+';
						}
						else if (map[x][y] == '.'){
							map[x][y] = '|';
						}
					}
					break;
				case 'D':
					if (x + 1 < n) {
						if (map[x][y] == '-') {
							map[x][y] = '+';
						}
						else if (map[x][y] == '.'){
							map[x][y] = '|';
						}
						x++;
						if (map[x][y] == '-') {
							map[x][y] = '+';
						}
						else if (map[x][y] == '.'){
							map[x][y] = '|';
						}
					}
					break;
				case 'R':
					if (y + 1 < n) {
						if (map[x][y] == '|') {
							map[x][y] = '+';
						}
						else if (map[x][y] == '.'){
							map[x][y] = '-';
						}
						y++;
						if (map[x][y] == '|') {
							map[x][y] = '+';
						}
						else if (map[x][y] == '.'){
							map[x][y] = '-';
						}
					}
					break;
				case 'L':
					if (y - 1 >= 0) {
						if (map[x][y] == '|') {
							map[x][y] = '+';
						}
						else if (map[x][y] == '.'){
							map[x][y] = '-';
						}
						y--;
						if (map[x][y] == '|') {
							map[x][y] = '+';
						}
						else if (map[x][y] == '.'){
							map[x][y] = '-';
						}
					}
					break;
				}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println("");
		}
	}
}