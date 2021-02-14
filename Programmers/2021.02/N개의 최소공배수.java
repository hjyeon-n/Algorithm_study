import java.util.Arrays;

public class Programmers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {3, 4, 9, 16};
		System.out.println(solution(arr));
	}
	
	public static int solution(int[] arr) {
        int len = arr.length;
        int answer = 1;
        
        while (true) {
        	int n = 2;
        	Arrays.sort(arr);
        	int max = arr[len - 1];
            int[] newArr = new int[len];
            
            while (n <= max) {
            	boolean flag= false;
	            for (int i = 0; i < len; i++) {
	                if (arr[i] % n == 0) {
	                    newArr[i] = arr[i] / n;
	                    flag = true;
	                }
	                else {
	                	newArr[i] = arr[i];
	                }
	            }
	            
	            if (flag) {
	            	answer *= n;
	            	arr = newArr;
	            	break;
	            }
	            n++;
            }
            
            boolean status = false;
            for (int i = 0; i < len; i++) {
            	if (arr[i] != 1) {
            		status = true;
            		break;
            	}
            }
            
            if (!status) {
            	break;
            }
        }
        
        return answer;
    }
}