public class Programmers {    
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
    	int[] arr = {1, 2, 3, 2, 3, 1};
    	int[] answer = solution(arr);
    	
    	for (int i = 0; i < arr.length; i++) {
    		System.out.print(answer[i] + " ");
    	}
    }

    public static int[] solution(int[] prices) {
    	int[] answer = new int[prices.length];
        int len = prices.length;
    	for (int i = 0; i < len; i++) {
    		for (int j = i + 1; j < len; j++) {
    			if (prices[i] > prices[j]) {
    				answer[i] = j - i;
    				break;
    			}
    			if (j == len - 1) {
        			answer[i] = j - i;
        		}
    		}
    	}
    	return answer;
    }
}
