import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_11723 {
    public static void main(String[] args) throws IOException{
    	// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int M = Integer.parseInt(br.readLine());
        int bitmask = 0;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	String command = st.nextToken();
        	
        	if (command.equals("add")) {
        		int n = Integer.parseInt(st.nextToken());
        		bitmask = bitmask | 1 << (n - 1);
        	}
        	else if (command.equals("remove")) {
        		int n = Integer.parseInt(st.nextToken());
                bitmask = bitmask & ~(1 << (n - 1));
        	}
        	else if (command.equals("check")) {
        		int n = Integer.parseInt(st.nextToken());
                sb.append(((bitmask & 1 << (n - 1)) == 1 << (n - 1) ? 1 : 0) + "\n");
        	}
        	else if (command.equals("toggle")) {
        		 int n = Integer.parseInt(st.nextToken());
                 bitmask = bitmask ^ 1 << (n - 1);
        	}
        	else if (command.equals("all")) {
        		bitmask = ~0;
        	}
        	else if (command.equals("empty")) {
        		bitmask = 0;
        	}
        }
        System.out.println(sb.toString());
    }
}