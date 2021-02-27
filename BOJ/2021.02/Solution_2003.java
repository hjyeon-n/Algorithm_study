import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2003 {
    public static void main(String[] args) throws IOException{
    	// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        
        for (int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int s = 0, e = 0;
        int cnt = 0;
        int sum = 0;
        
        while (true) {
        	if (sum >= M) {
        		sum -= arr[s];
        		s++;
        	}
        	else if (e == N) {
        		break;
        	}
        	else {
        		sum += arr[e];
        		e++;
        	}
        	
        	if (sum == M) {
    			cnt++;
    		}
        }
        System.out.println(cnt);
    }
}