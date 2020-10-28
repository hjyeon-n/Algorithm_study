public class Programmers {
	static boolean[] visited;
	static int[] arr;
	static int answer;
	public static void main(String[] args) {
    	// TODO Auto-generated method stub
    	System.out.print(solution(78));
    }
    
	public static int solution(int n) {
        int answer = 0;
        int cnt = Integer.bitCount(n);
        
        while (true) {
            n = n + 1;
            int next_cnt = Integer.bitCount(n);
            
            if (next_cnt == cnt) {
                answer = n;
                break;
            }
        }
        return answer;
    }
}