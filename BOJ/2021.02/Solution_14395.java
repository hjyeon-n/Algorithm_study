import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_14395 {
	static ArrayList<String> list;
    public static void main(String[] args) throws IOException{
    	// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        list = new ArrayList<String>();
        
        if (s == t) {
        	System.out.println("0");
        	return;
        }
        
        bfs(s, t);
        
        if (list.size() == 0) {
        	System.out.println("-1");
        	return;
        }
        
        Collections.sort(list);
        System.out.println(list.get(0));
    }
    
    public static void bfs(int s, int t) {
    	HashSet<Long> set = new HashSet<Long>();
    	Queue<Point> queue = new LinkedList<Point>();
    	queue.add(new Point(s, ""));
    
    	while (!queue.isEmpty()) {
    		Point point = queue.poll();
    		long val = point.val;
    		String str = point.str;
    		
    		if (val == t) {
    			list.add(str);
    		}
    		
    		if (val * val <= 1000000000 && !set.contains(val * val)) {
    			queue.add(new Point(val * val, str + "*"));
    			set.add(val * val);
    		}
    		
    		if (val + val <= 1000000000 && !set.contains(val + val)) {
    			queue.add(new Point(val + val, str + "+"));
    			set.add(val + val);
    		}
    		
    		if (!set.contains(val - val)) {
    			queue.add(new Point(0, str + "-"));
    			set.add(val - val);
    		}

    		if (val != 0 && !set.contains(val / val)) {
    			queue.add(new Point(1, str + "/"));
    			set.add(val / val);
    		}
    	}
    }
}

class Point {
	long val;
	String str;
	
	public Point(long val, String str) {
		this.val = val;
		this.str = str;
	}
}