public class Main {
	public static void main(String[] args){
		// TODO Auto-generated method stub
		int[] numbers = {1,2,3,4,6,7,8,0};
		System.out.println(solution(numbers));
	}

	 public static int solution(int[] numbers) {
	        int answer = 45;
	        
	        for (int i = 0; i < numbers.length; i++) {
	            answer -= numbers[i];
	        }
	        
	        return answer;      
	 }
}