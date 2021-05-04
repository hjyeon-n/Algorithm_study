import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static ArrayList<Node> list;
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<Node>();
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			list.add(new Node(A, B, C));
		}
		
		arr = new int[V + 1];
		
		for (int i = 1; i <= V; i++) {
			arr[i] = i;
		}
		
		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				if (o1.w > o2.w) {
					return 1;
				}
				else if (o1.w < o2.w) {
					return -1;
				}
				return 0;
			}
		});
		
		int answer = 0;
		for (int i = 0; i < E; i++) {
			Node node = list.get(i);
			int x = node.x;
			int y = node.y;
			int w = node.w;
			
			if (find(x) != find(y)) {
				union(x, y);
				answer += w;
			}
		}
		
		System.out.println(answer);
	}
	
	public static int find(int v) {
		if (v == arr[v]) {
			return v;
		}
		return v = find(arr[v]);
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x < y) {
			arr[y] = x;
		}
		else {
			arr[x] = y;
		}
	}
}

class Node {
	int x;
	int y;
	int w;
	
	public Node (int x, int y, int w) {
		this.x = x;
		this.y = y;
		this.w = w;
	}
}
