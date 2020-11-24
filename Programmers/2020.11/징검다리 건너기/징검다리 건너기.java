public class Programmers {
	public static void main(String[] args) {
    	// TODO Auto-generated method stub
		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		System.out.println(solution(stones, 3));
    }
    
	public static int solution(int[] stones, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (int i : stones) {
        	max = Math.max(max, i);
        	min = Math.min(min, i);
        }
        
        int answer = binarySearch(stones, k, min, max);
        return answer;
    }
	
	public static int binarySearch(int[] stones, int k, int l, int r) {
		if (l == r) {
			return l;
		}
		
		while (l < r) {
			int mid = l + (r - l) / 2;
			
			if (isPossible(stones, k, mid)) {
				l = mid + 1;
			}
			else {
				r = mid;
			}
		}
		return l - 1;
	}
	
	public static boolean isPossible(int[] stones, int k, int friends) {
		int cnt = 0;
		
		for (int stone : stones) { 
			if (stone - friends < 0) {
				cnt++;
			}
			else {
				cnt = 0;
			}
			
			if (cnt == k) {
				return false;
			}
		}
		return true;
	}
}