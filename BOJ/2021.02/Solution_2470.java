import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2470 {
    public static void main(String[] args) throws IOException{
    	// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        int min = Integer.MAX_VALUE;
        
        int rslt_start = 0;
        int rslt_end = N - 1;
        
        for (int i = 0; i < arr.length; i++) {
        	int val = arr[i] * -1;
        	int start = 0;
            int end = N - 1;
            
	        while (start <= end) {
	        	int mid = (start + end) / 2;
	        	
	        	if (arr[mid] == val) {
	        		min = 0;
	        		rslt_start = i;
		        	rslt_end = mid;
	        		break;
	        	}
	        	else {
	        		if (arr[mid] < val) {
	        			start = mid + 1;
	        		}
	        		else {
	        			end = mid - 1;
	        		}
	        	}
	        }
	        
	        if (start > N - 1) {
	        	start = N - 1;
	        }
	        
	        if (end < 0) {
	        	end = 0;
	        }
	        
	        if (start > end) {
	        	int tmp_val = start;
	        	start = end;
	        	end = tmp_val;
	        }
	        
	        int tmp = Integer.MAX_VALUE;
	        int tmp_start = 0;
	        int tmp_end = N - 1;
	        for (int j = start; j <= end; j++) {
	        	if (j == i) {
	        		continue;
	        	}
	        	if (Math.abs(tmp) > Math.abs(arr[i] + arr[j])) {
	        		tmp = arr[i] + arr[j];
	        		tmp_start = i;
	        		tmp_end = j;
	        	}
	        }
	        
	        if (Math.abs(min) > Math.abs(tmp)) {
	        	min = tmp;
	        	rslt_start = tmp_start;
	        	rslt_end = tmp_end;
	        }
        }
       
        if (arr[rslt_start] < arr[rslt_end]) {
        	System.out.println(arr[rslt_start] + " " + arr[rslt_end]);
        }
        else {
        	System.out.println(arr[rslt_end] + " " + arr[rslt_start]);
        }
    }
}