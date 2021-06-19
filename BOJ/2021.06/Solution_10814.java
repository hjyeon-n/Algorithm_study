import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_10814 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Node[] arr = new Node[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			
			arr[i] = new Node(age, name);
		}
		
		Arrays.sort(arr, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.age - o2.age;
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for (Node node : arr) {
			sb.append(node.age + " " + node.name + "\n");
		}
		
		System.out.println(sb.toString());
	}
}

class Node {
	int age;
	String name;
	
	public Node(int age, String name) {
		this.age = age;
		this.name = name;
	}
}
