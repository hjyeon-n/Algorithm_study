import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException{
    	// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for (int i = 1; i <= N; i++) {
        	String str = br.readLine();
        	map.put(str, i);
        }
        
        int[] out = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
        	String str = br.readLine();
        	out[i] = map.get(str);
        }
        
        int answer = 0;
        for (int i = 1; i < N; i++) {
        	for (int j = i + 1; j <= N; j++) {
        		if (out[i] > out[j]) {
        			answer++;
        			break;
        		}
        	}
        }
        
        System.out.println(answer);
    }
}