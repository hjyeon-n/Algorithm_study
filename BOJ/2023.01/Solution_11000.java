import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_11000 {
	static ArrayList<Node> list;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		list = new ArrayList<Node>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			list.add(new Node(s, t));
		}
		
		list.sort(Comparator.comparing(Node::getS).thenComparing(Node::getT));
		
		System.out.println(getClassRoom());
	}
	
	public static int getClassRoom() {		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); 
		
		for (Node node : list) {
			if (!pq.isEmpty() && pq.peek() <= node.getS()) {
				pq.poll();
			}
			pq.add(node.getT());
		}
		
		return pq.size();
	}
}

class Node {
	private int s;
	private int t;
	
	public Node(int s, int t) {
		this.s = s;
		this.t = t;
	}
	
	public int getS() {
		return s;
	}
	
	public int getT() {
		return t;
	}
}