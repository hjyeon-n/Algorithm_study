import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] indegree, time, rslt;
	static ArrayList<ArrayList<Integer>> graph;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//		소요 시간 : 50분
		//		체감 난이도 : 골드5

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList<ArrayList<Integer>>();
		time = new int[N + 1];
		rslt = new int[N + 1];
		indegree = new int[N + 1];
		
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int t = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			
			time[i] = t;
			for (int j = 0; j < cnt; j++) {
				int num = Integer.parseInt(st.nextToken());
				graph.get(i).add(num);
				indegree[num] += 1;
			}
		}
		
		topologySort();
		
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			answer = Math.max(answer, rslt[i]);
		}
		
		System.out.println(answer);
	}
	
	public static void topologySort() {
		for (int i = 1; i <= N; i++) {
			rslt[i] = time[i];
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
			}
		}
		
		while (!queue.isEmpty()) {
			int now = queue.poll();
			
			for (int i = 0; i < graph.get(now).size(); i++) {
				int v = graph.get(now).get(i);
				rslt[v] = Math.max(rslt[v], rslt[now] + time[v]);
				indegree[v] -= 1;
				
				if (indegree[v] == 0) {
					queue.add(v);
				}
			}
		}
	}
}