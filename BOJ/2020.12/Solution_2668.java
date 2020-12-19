import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution_2668 {
	static int[] arr;
	static PriorityQueue<Integer> pq;
	static boolean[] visited;
	static boolean[] finished;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		arr = new int[n + 1];
		visited = new boolean[n + 1];
		finished = new boolean[n + 1];
		pq = new PriorityQueue<>();

		for (int j = 1; j <= n; j++) {
			arr[j] = Integer.parseInt(br.readLine());
		}

		for (int j = 1; j <= n; j++) {
			if (!visited[j]) {
				dfs(j);
			}
		}

		System.out.println(pq.size());
		
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}
	
	public static void dfs(int now) {
        visited[now] = true;
        int next = arr[now];
 
        if (!visited[next]) {
            dfs(next);
        }
        else {
            if (!finished[next]) {
            	int find = next;
                
                while(true) {
                    pq.add(find);
                    if(find == now) {
                        break;
                    }
                    find = arr[find];
                }
            }
        }
 
        finished[now] = true;
	}
}