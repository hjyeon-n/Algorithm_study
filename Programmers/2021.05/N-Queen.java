
public class Main {
	static int[] arr;
	public static int cnt;
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
		System.out.println(solution(4));
	}

	public static int solution(int n) {
        cnt = 0;
        
        for (int i = 1; i <= n; i++) {
			arr = new int[n + 2];
			arr[1] = i; // 인덱스는 행, 값은 열을 의미
			dfs(n, 1);
		}		
        
        return cnt;
    }
    
    public static void dfs(int n, int row) {
		if(row == n) {
            cnt++;
        }
		for (int i = 1; i <= n; i++) {
			arr[row + 1] = i; 
			if (isPossible(row + 1)) {
                dfs(n, row + 1);
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