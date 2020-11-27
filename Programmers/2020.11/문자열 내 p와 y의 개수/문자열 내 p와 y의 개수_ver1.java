public class Programmers {
	public static void main(String[] args) {
    	// TODO Auto-generated method stub
		System.out.println(solution("pPoooyY"));
    }
    
	static boolean solution(String s) {
        boolean answer = true;
        int p_num = 0, y_num = 0;

        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            char alpha = s.charAt(i);
            if (alpha == 'p') {
                p_num++;
            }

            if (alpha == 'y') {
                y_num++;
            }
        }

        if (p_num != y_num) {
            answer = false;
        }

        return answer;
    }
}