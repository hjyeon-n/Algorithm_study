import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	static int[] arr;
	static int n;
	public static int cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= n; i++) {
			arr = new int[n + 2];
			arr[1] = i; // 인덱스는 행, 값은 열을 의미
			dfs(1);
		}		
		System.out.println(cnt);
	}
	
	public static void dfs(int row) {
		if(row == n) {
            cnt++;
        }
		for (int i = 1; i <= n; i++) {
			arr[row + 1] = i; 
			if (isPossible(row + 1)) {
                dfs(row + 1);
            } 
		}
	}
	
	public static boolean isPossible(int row) {
	    for (int i = 1; i < row; i++) {
	        if (arr[i] == arr[row]) {
	            return false;
	        }
	        if (Math.abs(arr[i] - arr[row]) == Math.abs(i - row)) {
	            return false;
	        }
	    }
	    return true;
	}	
}