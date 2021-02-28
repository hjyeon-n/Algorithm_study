import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution_18870 {
    public static void main(String[] args) throws IOException{
    	// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        
        for (int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] clone = arr.clone();
        
        Arrays.sort(clone);
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        int idx = 0;
        for (int i = 0; i < N; i++) {
        	if (!map.containsKey(clone[i])) {
        		map.put(clone[i], idx++);
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
        	sb.append(map.get(arr[i]) + " ");
        }
        
        System.out.println(sb.toString());
    }
}