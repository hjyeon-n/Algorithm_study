import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_12851 {
	static HashSet<Integer> set;
	static int min;
	static int answer;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		set = new HashSet<Integer>();

		bfs(N, K);

		System.out.println(min);
		System.out.println(answer);
	}

	public static void bfs(int N, int K) {
		Queue<Location> queue = new LinkedList<Location>();
		queue.add(new Location(N, 0));
		min = Integer.MAX_VALUE;
		answer = 0;

		while(!queue.isEmpty()) {
			Location loc = queue.poll();
			int val = loc.val;
			int cnt = loc.cnt;
			
			set.add(val);

			if (min < cnt) {
				break;
			}

			if (val == K) {
				if (min >= cnt) {
					min = cnt;
					answer++;
				}
			}

			if (val + 1 <= 100000 && !set.contains(val + 1)) {
				queue.add(new Location(val + 1, cnt + 1));
			}

			if (val - 1 >= 0 && !set.contains(val - 1)) {
				queue.add(new Location(val - 1, cnt + 1));
			}

			if (val * 2 <= 100000 && !set.contains(val * 2)) {
				queue.add(new Location(val * 2, cnt + 1));
			}
		}
	}
}

class Location {
	int val;
	int cnt;

	public Location (int val, int cnt) {
		this.val = val;
		this.cnt = cnt;
	}
}