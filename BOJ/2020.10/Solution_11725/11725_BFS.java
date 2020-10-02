import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] visited;
	static int[] answer;
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		list = new ArrayList<ArrayList<Integer>>();
		visited = new boolean[N + 1];
		answer = new int[N + 1];
		
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		StringTokenizer st;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			
			list.get(parent).add(child);
			list.get(child).add(parent);
		}
		
		BFS(1);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 2; i <= N; i++) {
			sb.append(answer[i]).append('\n');
		}
		System.out.println(sb);	
	}
	
	public static void BFS(Integer x) {
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[x] = true;
		queue.offer(x);
		
		while (!queue.isEmpty()) {
			int v = queue.poll();
			ArrayList<Integer> tmp = list.get(v);
			
			for (int i = 0; i < tmp.size(); i++) {
				if (!visited[tmp.get(i)]) {
					queue.offer(tmp.get(i));
					answer[tmp.get(i)] = v;
					visited[tmp.get(i)] = true;
				}
			}
		}
	}
} 