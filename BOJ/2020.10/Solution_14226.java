import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_14226 {
	static boolean[][] visited; 
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int S = Integer.parseInt(br.readLine());
		visited = new boolean[1001][1001];
		getMinTime(S);
	}
	
	public static void getMinTime(int S) {
		Queue<Emoji> queue = new LinkedList<Emoji>();
		queue.add(new Emoji(1, 0, 0));
		visited[1][0] = true;
		
		while(!queue.isEmpty()) {
			Emoji e = queue.poll();
			
			if (S == e.display) {
				System.out.println(e.time);
				return;
			}
			
//			복사하는 경우
			if (!visited[e.display][e.display]) {
				queue.add(new Emoji(e.display, e.display, e.time + 1));
				visited[e.display][e.display] = true;
			}
			
//			붙여넣기하는 경우
			if (e.display + e.copy < 1001 && !visited[e.display + e.copy][e.copy]) {
				queue.add(new Emoji(e.display + e.copy, e.copy, e.time + 1));
				visited[e.display + e.copy][e.copy] = true;
			}
			
//			화면에서 제거할 경우
			if (e.display - 1 >= 0 && !visited[e.display - 1][e.copy]) {
				queue.add(new Emoji(e.display - 1, e.copy, e.time + 1));
				visited[e.display - 1][e.copy] = true;
			}
		}
	}
}

class Emoji {
	int display;
	int copy;
	int time;
	
	public Emoji(int display, int copy, int time) {
		super();
		this.display = display;
		this.copy = copy;
		this.time = time;
	}
}