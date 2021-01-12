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
        	sb.append(binarySearch(card, Integer.parseInt(st.nextToken())) + " ");
        }
        
        System.out.print(sb.toString());
    }
    
    public static int binarySearch(int[] card, int num) {
    	int first = 0;
    	int last = card.length - 1;
    	int mid;
    	
    	while (first <= last) {
    		mid = (first + last) / 2;
    		
    		if (card[mid] == num) {
    			return 1;
    		}
    		else {
    			if (num < card[mid]) {
    				last = mid - 1;
    			}
    			else {
    				first = mid + 1;
    			}
    		}
    	}
    	return 0;
    }
}