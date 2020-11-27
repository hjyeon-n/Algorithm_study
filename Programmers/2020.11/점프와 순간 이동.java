public class Programmers {
	public static void main(String[] args) {
    	// TODO Auto-generated method stub
		System.out.println(solution(5));
    }
    
	public static int solution(int n) {
        int ans = 0;
        
        String num = Integer.toBinaryString(n);
        
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '1'){
                ans++;
            }
        }

        return ans;
    }
}