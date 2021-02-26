import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_1764 {
    public static void main(String[] args) throws IOException{
    	// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
//        ArrayList<String> list = new ArrayList<String>();
        HashSet<String> set = new HashSet<String>();
        ArrayList<String> answer = new ArrayList<String>();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < N; i++) {
        	set.add(br.readLine());
        }
        
        for (int i = 0; i < M; i++) {
        	String str = br.readLine();
        	if (set.contains(str)) {
        		answer.add(str);
        	}
        }
        
        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        sb.append(answer.size() + "\n");
        
        for (int i = 0; i < answer.size(); i++) {
        	sb.append(answer.get(i) + "\n");
        }
        
        System.out.println(sb.toString());
    }
}