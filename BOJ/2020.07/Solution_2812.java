import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
 
public class Main {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        
        String str = br.readLine();
        for(int i = 0; i < n; i++) {
			arr[i] = str.charAt(i) - '0';
		}
        
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(arr[0]);
        
        for (int i = 1; i < arr.length; i++) {
        	while (!dq.isEmpty() && dq.getLast() < arr[i] && k > 0) {
        		dq.removeLast();
        		k--;
        	}
        	dq.addLast(arr[i]);
        }
 
        while (dq.size() > k) {
        	System.out.print(dq.removeFirst());
        }
    }
}
