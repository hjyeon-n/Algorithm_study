import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1916 {
	static ArrayList<Point>[] arrList;
    static int dist[];
    public static void main(String[] args) throws IOException{
    	// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        arrList = new ArrayList[N + 1];
        dist = new int[N + 1];
        
        for(int i = 1; i <= N; i++) {
            dist[i] = 987654321;
        }
        
        for(int i = 1; i <= N; i++) {
            arrList[i] = new ArrayList<>();
        }
        
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int u = Integer.parseInt(st.nextToken());
        	int v = Integer.parseInt(st.nextToken());
        	int w = Integer.parseInt(st.nextToken());
        	
        	arrList[u].add(new Point(v, w));
        }
        
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        solution(start);
        System.out.println(dist[end]);
    }
    
    public static void solution(int start) {
    	PriorityQueue<Point> pq = new PriorityQueue<Point>();
    	pq.add(new Point(start, 0));
    	dist[start] = 0;
    	
    	while (!pq.isEmpty()) {
    		Point point = pq.poll();
    		
    		if (dist[point.x] < point.y) {
    			continue;
    		}
    		
    		for (int i = 0; i < arrList[point.x].size(); i++) {
    			Point path = arrList[point.x].get(i);
    			
    			if (dist[path.x] > dist[point.x] + arrList[point.x].get(i).y) {
    				dist[path.x] = dist[point.x] + arrList[point.x].get(i).y;
    				pq.add(new Point(path.x, dist[path.x]));
    			}
    		}
    	}
    }
}

class Point implements Comparable<Point> {
	int x;
	int y;
	
	public Point (int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Point o) {
		// TODO Auto-generated method stub
		if (this.y - o.y < 0) {
			return 1;
		}
		
		return 0;
	}
	
}