import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1753 {
	static int stoi(String S) {
		return Integer.parseInt(S);
	}
	static final int INF = 1000000000;
	static int N, M, K;
	static List<List<Node>> adList; // ���� ����Ʈ
	static int[] dist; // �ּ� �Ÿ� ��� ���̺�
	static boolean[] visited;
	static PriorityQueue<Node> pq;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken()); // ������ ����
        M = stoi(st.nextToken()); // ������ ����
        K = stoi(br.readLine()); // �����
        
        adList = new ArrayList<>();
        // �ε����� 1���� �ϱ� ���� ���Ƿ� �� ���� �־��
        adList.add(new ArrayList<Node>());
        for(int i = 1; i <= N; i++) {
            adList.add(new ArrayList<Node>());
        }
        // dist[] INF�� �ʱ�ȭ
        dist = new int[N + 1];
        Arrays.fill(dist, INF);
        
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
        	int u = stoi(st.nextToken());
        	int v = stoi(st.nextToken());
        	int cost = stoi(st.nextToken());
        	adList.get(u).add(new Node(v, cost));
        }
       
        dijkstra(K);
        
        for (int i = 1; i <= N; i++) {
        	if (dist[i] >= INF) {
        		System.out.println("INF");
        	}
        	else {
        		System.out.println(dist[i]);
        	}
        }
    }
     
    private static void dijkstra(int start) {
    	pq = new PriorityQueue<>();
    	visited = new boolean[N+1];
    	
    	dist[start] = 0;
    	pq.add(new Node(start, 0));
    	
    	while(!pq.isEmpty()) {
    		Node current =  pq.poll();
    		// ��湮 ���� Ȯ��
    		if(visited[current.ID]) continue;
    		visited[current.ID] = true;
    		// ����� �������� Ȯ�� 
            for(Node next : adList.get(current.ID)) {
            	// ȿ������ ó���� ���� �ּ� �Ÿ� ����� ���ŵǴ� ��츸 queue�� �־��ݴϴ�.
            	if(dist[next.ID] > dist[current.ID] + next.distance) {
            		// �ּ� �Ÿ� ��� ����
                    dist[next.ID] = dist[current.ID] + next.distance;
                    pq.add(new Node(next.ID, dist[next.ID]));
                }
            }
    	}
	}
}

class Node implements Comparable<Node>{
	int ID;
	int distance;
	
	public Node(int ID, int distance) {
		this.ID = ID;
		this.distance = distance;
	}
	
    @Override
    public int compareTo(Node target) {
          // ���� �Ÿ� ����� ���� ������
          return this.distance - target.distance;
    }
}