
public class Programmers {
	static int answer;
    static boolean[] visited;
    static int[] arr;
    
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
    	int[] numbers = {1, 1, 1, 1, 1};
    	System.out.println(solution(numbers, 3));
    }

    public static int solution(int[] numbers, int target) { 
        dfs(target, numbers, 0); 
        return answer; 
    } 
    
    public static void dfs(int target, int[] numbers, int k) { 
        if (k == numbers.length) { 
            int sum = 0; 
            for (int i = 0; i < numbers.length; i++) {
                sum += numbers[i]; 
            } 
            
            if (sum == target) {
                answer++; 
            }  
            return; 
        } 
        else { 
            numbers[k] *= 1; 
            dfs(target, numbers, k + 1); 
            numbers[k] *= -1; 
            dfs(target, numbers, k + 1); 
        }
    } 
}
