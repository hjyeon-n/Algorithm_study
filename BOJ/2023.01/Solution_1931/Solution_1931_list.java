import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_1931_list {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		Node[] arr = new Node[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			arr[i] = new Node(start, end);
		}
		
//		종료 시점으로 정렬
		Arrays.sort(arr, Comparator.comparing(Node::getEnd).thenComparing(Node::getStart));
		
		int endTime = arr[0].getEnd();
		int cnt = 1;
		
		for (int i = 1; i < N; i++) {
			if (endTime <= arr[i].getStart()) {
				endTime = arr[i].getEnd();
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}

class Node {
	private int start;
	private int end;
	
	public Node(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	public int getStart() {
		return start;
	}
	
	public int getEnd() {
		return end;
	}
}