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
        String binary_n = Integer.toBinaryString(n);
        
        int cnt = 0;
        for (int i = 0; i < binary_n.length(); i++) {
            if (binary_n.charAt(i) == '1') {
                cnt++;
            }
        }
        
        while (true) {
            n = n + 1;
            String next_n = Integer.toBinaryString(n);
            
            int next_cnt = 0;
            for (int i = 0; i < next_n.length(); i++) {
                if (next_n.charAt(i) == '1') {
                    next_cnt++;
                }
            }
            
            if (next_cnt == cnt) {
                answer = n;
                break;
            }
        }
        return answer;
    }
}