import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[] visited;
	static int min;
	static int[] arr;
	static ArrayList<Location> home;
	static ArrayList<Location> chicken;
	
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
			
		home = new ArrayList<Location>();
		chicken = new ArrayList<Location>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int value = Integer.parseInt(st.nextToken());
				
				if (value == 1) {
					home.add(new Location(i, j));
				}
				
				if (value == 2) {
					chicken.add(new Location(i, j));
				}
			}
		}
		
		arr = new int[chicken.size()];
		min = Integer.MAX_VALUE;
		visited = new boolean[chicken.size()];
		pick(chicken.size(), M, 0, 0);
		System.out.println(min);
	}
	
	private static void pick(int n, int m, int depth, int idx) {
		if (depth == m) {
			int sum = 0;
			for (int i = 0; i < home.size(); i++) {
				Location h_loc = home.get(i);
				int min_chicken = Integer.MAX_VALUE;
				for (int j = 0; j < m; j++) {
					Location c_loc = chicken.get(arr[j] - 1);
					min_chicken = Math.min(min_chicken, Math.abs(h_loc.x - c_loc.x) + Math.abs(h_loc.y - c_loc.y));
				}
				sum += min_chicken;
			}
			min = Math.min(min, sum);
			return;
		}
	 
		for (int i = idx; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = i + 1;	
				pick(n, m, depth + 1, i);
				visited[i] = false;
			}
		}
	}
} 

class Location {
	int x;
	int y;
	
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}