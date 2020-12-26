import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_16964 {
	static ArrayList<ArrayList<Integer>> adj;
	static int[] order;
	static boolean[] check;
	static int N, idx;
	static boolean flag;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		idx = 1;
		flag = true;
		check = new boolean[N + 1];
		adj = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		StringTokenizer st;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			adj.get(x).add(y);
			adj.get(y).add(x);
		}
		
		st = new StringTokenizer(br.readLine());
		
		order = new int[N];
		
		for (int i = 0; i < N; i++) {
			order[i] = Integer.parseInt(st.nextToken());
		}
		
		if (order[0] != 1) {
			System.out.println("0");
			return;
		}
		
		dfs(1); 
		
		if (flag) {
			System.out.println("1");
		}
		else {
			System.out.println("0");
		}
	}
	
	public static void dfs(int x) {
	    if (check[x]) {
	        return;
	    }
	    check[x] = true;
	    // x¸¦ ¹æ¹®
	    ArrayList<Integer> list = new ArrayList<Integer>();
	    for (int y : adj.get(x)) {
	    	if (!check[y]) {
	            list.add(y);
	        }
	    }
	    
	    if (list.size() == 0) {
	    	return;
	    }
	    
	    if(list.contains(order[idx])) {
			dfs(order[idx++]);
		} else {
			flag = false;
		}
	}
}