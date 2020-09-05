import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 1707_ver2 {
	static int V, E;
	static int colors[];
	static ArrayList<ArrayList<Integer>> map;
	static boolean flag;
	static final int RED = 1;
    static final int BLUE = -1;
	public static void main(String[] args) throws NumberFormatException, IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			map = new ArrayList<>();
			for (int j = 0; j <= V; j++) { 
				map.add(new ArrayList<Integer>()); 
			}
			
			colors = new int[V + 1];
			
			for (int j = 0; j < E; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map.get(x).add(y);
				map.get(y).add(x);
			}
			
			flag = true;
			
			for (int j = 1; j <= V; j++) {
				if (!flag) {
					break;
				}
				
				if (colors[j] == 0) {
					bfs(j, RED);
				}
			}
				
			if (flag) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
	}
	public static void bfs(int k, int color) {
		Queue<Integer> queue = new LinkedList<Integer>();
		colors[k] = color;
		queue.add(k);
		
		while (!queue.isEmpty() && flag) {
			int x = queue.poll();
			
			if (x > V) {
				break;
			}
			
			for (int adjV : map.get(x)) {
				if(colors[adjV] == 0){
					queue.add(adjV);
					colors[adjV] = colors[x] * -1;
				}
				else if (colors[x] + colors[adjV] != 0) {
					flag = false;
					return;
				}
			}
		}
    }
}