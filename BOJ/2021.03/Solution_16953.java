import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_16953 {
	static int min;
	static HashSet<Long> set;
    public static void main(String[] args) throws IOException{
    	// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        min = Integer.MAX_VALUE;
        set = new HashSet<Long>();
        
        bfs(A, B);
        
        if (min != Integer.MAX_VALUE) {
        	System.out.println(min + 1);
        }
        else {
        	System.out.println(-1);
        }
    }
    
    public static void bfs(long A, long B) {
    	Queue<Node> queue = new LinkedList<Node>();
    	queue.add(new Node(A, 0));
    	set.add(A);
    	
    	while (!queue.isEmpty()) {
    		Node node = queue.poll();
    		long val = node.val;
    		int cal = node.cal;
    		
    		if (val > B) {
    			continue;
    		}
    		
    		if (val == B) {
    			min = Math.min(min, cal);
    			break;
    		}
    		
    		if (!set.contains(val * 2)) {
    			queue.add(new Node(val * 2, cal + 1));
    			set.add(val * 2);
    		}
    		
    		String tmp = String.valueOf(val) + "1";
    		long newVal = Long.parseLong(tmp);
    		if (!set.contains(newVal)) {
    			queue.add(new Node(newVal, cal + 1));
    			set.add(newVal);
    		}
    	}
    }
}

class Node {
	public long val;
	public int cal;
	
	public Node(long val, int cal) {
		this.val = val;
		this.cal = cal;
	}
}