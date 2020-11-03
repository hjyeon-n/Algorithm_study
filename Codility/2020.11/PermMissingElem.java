import java.util.Arrays;
public class PermMissingElem {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2, 3, 1, 5};
		System.out.println(solution(A));
	}

	public static int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int cnt = 1;
        int len = A.length;
        
        for (int i = 0; i < len; i++) {
            if (cnt != A[i]) {
                return cnt;
            }
            cnt++;
        }
        return cnt;
    }
}