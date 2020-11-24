// 정확성만 100
public class Programmers {
	public static void main(String[] args) {
    	// TODO Auto-generated method stub
		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		System.out.println(solution(stones, 3));
    }
    
	public static int solution(int[] stones, int k) {
        int answer = 0;
        int len = stones.length;
        
        while (true) {
            int cnt = 0;
            boolean flag = true;
            for (int i = 0; i < len; i++) {
                if(stones[i] != 0) {
                    cnt = 0;
                    stones[i] -= 1;
                }
                else {
                    cnt++;
                }
                
                if (cnt >= k) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                answer++;
            }
            else {
                break;
            }
        }
        
        return answer;
    }
}