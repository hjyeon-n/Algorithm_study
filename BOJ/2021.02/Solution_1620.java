import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution_1620 {
    public static void main(String[] args) throws IOException{
    	// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        HashMap<Integer, String> map1 = new HashMap<Integer, String>();
        HashMap<String, Integer> map2 = new HashMap<String, Integer>();
        
        for (int i = 0; i < N; i++) {
        	String str = br.readLine();
        	map1.put(i + 1, str);
        	map2.put(str, i + 1);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
        	String str = br.readLine();
        	char alpha = str.charAt(0);
        	
        	if (Character.isDigit(alpha)) {
        		sb.append(map1.get(Integer.parseInt(str)) + "\n");
        	}
        	else {
        		sb.append(map2.get(str) + "\n");
        	}
        }
        
        System.out.println(sb.toString());
    }
}