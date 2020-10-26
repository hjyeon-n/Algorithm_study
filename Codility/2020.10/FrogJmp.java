public class FrogJmp {
	public static void main(String[] args){
		// TODO Auto-generated method stub
		System.out.println(solution(10, 85, 30));
	}
	
	public static int solution(int X, int Y, int D) {
        // write your code in Java SE 8
        
        int diff = Y - X;
        
        if (diff % D == 0) {
            return diff / D;
        }
        return diff / D + 1;
    }
}