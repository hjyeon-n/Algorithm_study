
public class Programmers {
	public static void main(String[] args) {
    	// TODO Auto-generated method stub
		System.out.println(solution(10));
    }
    
	public static boolean solution(int x) {        
        int sum = getSum(x);
        return (x % sum == 0);
    }
    
    public static int getSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x = x / 10;
        }
        return sum;
    }
}