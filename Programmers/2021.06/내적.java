
public class Main {
	public static void main(String[] args){
		// TODO Auto-generated method stub
		int[] a = {1, 2, 3, 4};
		int[] b = {-3, -1, 0, 2};
		System.out.println(solution(a, b));
	}

	public static int solution(int[] a, int[] b) {
        int answer = 0;
        int len = a.length;
        
        for (int i = 0; i < len; i++) {
            answer += a[i] * b[i];
        }
        return answer;
    }
}