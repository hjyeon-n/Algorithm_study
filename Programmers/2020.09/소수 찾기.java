import java.util.HashSet;

public class Programmers2 {
	static HashSet<Integer> set;
    static boolean[] visited;
    static int[] arr;
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("17"));
	}
	
	public static int solution(String numbers) {
		set = new HashSet<Integer>();
        int len = numbers.length();
        
//         배열에 값 입력, 값 하나하나가 소수인지 판별
        int[] digits = new int[len];
        for (int i = 0; i < len; i++) {
            digits[i] = numbers.charAt(i) - '0';
            isPrime(digits[i]);
        }
        
//         순열로 수 조합
        for (int i = 2; i <= len; i++) {
            arr = new int[len];
            visited = new boolean[len];
            pick(len, i, 0, digits);
        }
           
        return set.size();
    }
    
    public static void pick(int n, int m, int depth, int[] digits) {
        if (depth == m) {
            String str = "";
            for (int i = 0; i < m; i++) {
                str += String.valueOf(arr[i]);
            }
            if (!str.startsWith("0")) {
            	int num = Integer.parseInt(str);
                isPrime(num);
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = digits[i];
                pick(n, m, depth + 1, digits);
                visited[i] = false;
            }
        }
    }
    
    public static void isPrime(int n) {
    	if (n == 1 || n == 0) {
    		return;
    	}
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return;
            }
        }
        set.add(n);
        return;
    }
}
