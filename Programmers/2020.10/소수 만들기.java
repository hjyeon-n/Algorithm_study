public class Programmers {
	static boolean[] visited;
	static int[] arr;
	static int answer;
	public static void main(String[] args) {
    	// TODO Auto-generated method stub
    	int[] nums = {1, 2, 7, 6, 4};
    	
    	System.out.print(solution(nums));
    }
    
	public static int solution(int[] nums) {
		int len = nums.length;
		visited = new boolean[len];
		arr = new int[len];
		dfs(len, 3, 0, 0, nums);
        return answer;
    }
	
	public static void dfs(int n, int m, int depth, int idx, int[] nums) {
		if (depth == m) {
			int sum = 0;
			
			for (int i = 0; i < m; i++) {
				sum += arr[i];
			}
			
			if (isPrime(sum)) {
				answer++;
			}
			
			return;
		}
	 
		for (int i = idx; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = nums[i];	
				dfs(n, m, depth + 1, i, nums);
				visited[i] = false;
			}
		}
	}
	
	public static boolean isPrime(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}