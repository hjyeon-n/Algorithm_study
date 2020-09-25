import java.util.Arrays;

public class Programmers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] citations = {3, 0, 6, 1, 5};
		System.out.println(solution(citations));
	}
	
	public static int solution(int[] citations) {
		Arrays.sort(citations);

        int max = 0;
        for(int i = citations.length - 1; i > -1; i--){
            int min = Math.min(citations[i], citations.length - i);
            if(max < min) {
            	max = min;
            }
        }
        return max;
    }
}
