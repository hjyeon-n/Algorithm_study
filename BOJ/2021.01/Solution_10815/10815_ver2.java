import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
    	// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] card = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
        	card[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(card);
        
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < M; i++) {
        	int num = Integer.parseInt(st.nextToken());
        	sb.append(((Arrays.binarySearch(card, num) < 0) ? 0 : 1) + " ");
        }
        
        System.out.print(sb.toString());
    }
}