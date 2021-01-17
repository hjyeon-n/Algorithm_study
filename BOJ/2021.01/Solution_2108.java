import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;

public class Solution_2108 {
    public static void main(String[] args) throws IOException{
    	// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        double sum = 0;
        int min = 4000;
        int max = -4000;
        
        StringBuilder sb = new StringBuilder();
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        	min = Math.min(min, arr[i]);
        	max = Math.max(max, arr[i]);
        	sum += arr[i];
        }
        
        sb.append(Math.round((double)sum / N) + "\n");
        
        Arrays.sort(arr);
        sb.append(arr[N/ 2] + "\n");
        
        for (int i = arr.length - 1; i >= 0; i--) {
	        if (map.containsKey(arr[i])) {
	    		map.put(arr[i], map.get(arr[i]) + 1);
	    	}
	    	else {
	    		map.put(arr[i], 1);
	    	}
        }
        
        ArrayList<Integer> keyList = new ArrayList<>(map.keySet());
        if (map.size() == 1) {
        	sb.append(arr[0] + "\n");
        }
        else {
	        Collections.sort(keyList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));
	        
	        if (map.get(keyList.get(0)) == map.get(keyList.get(1))) {
	        	sb.append(keyList.get(1) + "\n");
	        }
	        else {
	        	sb.append(keyList.get(0) + "\n");
	        }
        }
        
        sb.append(max - min + "\n");
        System.out.println(sb.toString());
    }
}