public class Programmers {
	public static void main(String[] args) {
    	// TODO Auto-generated method stub
		System.out.println(solution("pPoooyY"));
    }
    
	static boolean solution(String s) {
        int cnt = 0;

        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            char alpha = s.charAt(i);
            if (alpha == 'p') {
                cnt++;
            }

            if (alpha == 'y') {
                cnt--;
            }
        }

        return (cnt == 0);
    }
}