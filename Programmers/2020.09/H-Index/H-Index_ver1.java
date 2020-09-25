import java.util.Arrays;

public class Programmers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] citations = {3, 0, 6, 1, 5};
		System.out.println(solution(citations));
	}
	
	public static int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        int arr_size = citations.length;
        for (int i = 1; i <= arr_size; i++) {
            int big = 0;
            int small = 0;
            
            for (int j = 0; j < arr_size; j++) {
                if (citations[j] < i) {
                    small++;
                }
                else {
                    big++;

                    if (big >= i) {
                        break;
                    }
                }
            }
            
            if (small <= i && big >= i) {
                answer = i;
            }
            else {    
                return answer;
            }
        }
        return answer;
    }
}
