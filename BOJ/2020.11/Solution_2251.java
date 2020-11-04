import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2251 {
	static int[] bottle;
	static boolean[][][] visited;
	static ArrayList<Integer> list;
	static int [] from = {2, 2, 1, 1, 0, 0}; 
    static int [] to = {0, 1, 0, 2, 1, 2};

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		bottle = new int[3];
		
		for (int i = 0; i < 3; i++) {
			bottle[i] = Integer.parseInt(st.nextToken());
		}
		list = new ArrayList<Integer>();
		pourWater();
		
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		for (int i : list) {
			sb.append(i + " ");
		}
		System.out.println(sb);
	}
	
	public static void pourWater() {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(0, 0, bottle[2]));
		visited = new boolean[bottle[0] + 1][bottle[1] + 1][bottle[2] + 1];
		
		while(!queue.isEmpty()) {
            Node node = queue.poll();
            
            if(visited[node.x][node.y][node.z]) {
                continue;
            }
            
            if(node.x == 0) {
                list.add(node.z);
            }
            
            visited[node.x][node.y][node.z] = true;
            
            if(node.x + node.y <= bottle[0]) {
                queue.add(new Node(node.x + node.y, 0, node.z));
            }
            else {
                queue.add(new Node(bottle[0], node.y + node.x - bottle[0], node.z));
            }
            
            if(node.x + node.z <= bottle[0]) {
                queue.add(new Node(node.x + node.z, node.y, 0));
            }
            else {
                queue.add(new Node(bottle[0], node.y, node.z + node.x - bottle[0]));
            }
            
            if(node.y + node.x <= bottle[1]) {
                queue.add(new Node(0, node.x + node.y, node.z));
            }
            else {
                queue.add(new Node(node.x + node.y - bottle[1], bottle[1], node.z));
            }
            
            if(node.y + node.z <= bottle[1]) {
                queue.add(new Node(node.x, node.y + node.z, 0));
            }
            else {
                queue.add(new Node(node.x, bottle[1], node.z + node.y - bottle[1]));
            }
            
            if(node.z + node.x <= bottle[2]) {
                queue.add(new Node(0, node.y, node.z + node.x));
            }
            else {
                queue.add(new Node(node.x + node.z - bottle[2], node.y, bottle[2]));
            }
            
            if(node.z + node.y <= bottle[2]) {
                queue.add(new Node(node.x, 0, node.z + node.y));
            }
            else {
                queue.add(new Node(node.x, node.y + node.z - bottle[2], bottle[2]));
            }
        }
	}
}

class Node {
	int x;
	int y;
	int z;
	
	public Node (int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}