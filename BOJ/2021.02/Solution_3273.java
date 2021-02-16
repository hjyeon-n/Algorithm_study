import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3273 {
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
        
        int x = Integer.parseInt(br.readLine());
        
        int cnt = 0;
        int start = 0;
        int end = N - 1;
        
        while (start < end) {
        	int sum = arr[start] + arr[end];
        	
        	if (sum == x) {
        		cnt++;
        	}
        	
        	if (sum <= x) {
        		start++;
        	}
        	
        	if (sum > x) {
        		end--;
        	}
        }
       
        System.out.println(cnt);
    }
}