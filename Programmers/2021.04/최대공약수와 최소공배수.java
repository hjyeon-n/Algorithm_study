
class Programmers {
	public static void main(String[] args) {
		int[] answer = solution(2, 5);
		
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
	
	public static int[] solution(int n, int m) {
        int divisor = 1;
        int multiple = 1;
        
        int calc = 1;
        while (true) {
            if (n == 1 && m == 1) {
                break;
            }
            
            if (n % calc == 0 && m % calc == 0) {
                n /= calc;
                m /= calc;
                multiple *= calc;
                divisor *= calc;
                calc = 1;
            }
            else if (n % calc == 0 || m % calc == 0) {
                if (n % calc == 0) {
                    n /= calc;
                }
                else {
                    m /= calc;
                }
                
                multiple *= calc;
                calc = 1;
            }
            
            calc++;
        }
        
        return new int[]{divisor, multiple};
    }
}
