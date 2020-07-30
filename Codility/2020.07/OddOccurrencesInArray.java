import java.io.IOException;

public class OddOccurrencesnArray {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int[] A = {9, 3, 9, 3, 7, 9, 9};
		System.out.println(solution(A));
	}
	
	public static int solution(int[] A) {
        // write your code in Java SE 8
		int result = 0;
        
        for(int i : A){
            result ^= i;
        }
        return result;
    }
}