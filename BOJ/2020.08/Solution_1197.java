import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_1197 {
	public static int[] parent;
    public static ArrayList<Edge> edgeList;
    
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		edgeList = new ArrayList<Edge>();
		parent = new int[N + 1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			// 1) S, E, V
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			edgeList.add(new Edge(S, E, V));
		}
		
		Collections.sort(edgeList);
		
		for(int i = 1; i <= N; i++) {
            parent[i] = i;
        }
		
		int sum = 0;
        for(int i = 0; i < M; i++) {
            Edge edge = edgeList.get(i);
            if(!isSameParent(edge.v1, edge.v2)) {
                sum += edge.cost;
                union(edge.v1, edge.v2);
            }
        }
		
        System.out.println(sum);
    }
	
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x != y) {
        	parent[y] = x;
        }
    }
	
    public static int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    public static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        if(x == y) {
        	return true;
        }
        else {
        	return false;
        }
    }
}

class Edge implements Comparable<Edge> {
    int v1;
    int v2;
    int cost;
    Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge o) {
        if(this.cost < o.cost)
            return -1;
        else if(this.cost == o.cost)
            return 0;
        else
            return 1;
    }
}