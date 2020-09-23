import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Programmers {
	static ArrayList<Integer> preorder;
	static ArrayList<Integer> postorder;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] nodeinfo = {
				{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}};
		System.out.println(solution(nodeinfo));
	}

	public static int[][] solution(int[][] nodeinfo) {	
		ArrayList<Node> list = new ArrayList<Node>();
		for (int i = 0; i < nodeinfo.length; i++) {
			list.add(new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]));
		}
		
		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				int a = o1.loc_y;
				int b = o2.loc_y;
				if (a > b) {
					return -1;
				}
				if (a < b) {
					return 1;
				}
				return 0;
			}
		});
		Node root = list.get(0);
		while (!list.isEmpty()) {
			root = insertNode(root, list.get(0));
			list.remove(0);
		}
		preorder = new ArrayList<Integer>();
		preorder(root);
		postorder = new ArrayList<Integer>();
		postorder(root);
		
		int[][] answer = new int[2][nodeinfo.length];
		for (int j = 0; j < nodeinfo.length; j++) {
			answer[0][j] = preorder.get(j);
			answer[1][j] = postorder.get(j);
		}
		return answer;
	}
	
	static Node insertNode (Node tree, Node node) {
		Node t = tree; // 삽입할 위치
		Node p = null; // 상위 노드 참조
		int value = node.loc_x;

		while(t != null){
			if(t.loc_x == value) {
				return t;
			}

			p = t;

			if(p.loc_x > value) {
				t = p.left;
			}
			else {
				t = p.right;
			}
		}

		if(p != null){ 
			if(p.loc_x > value) {
				p.left = node;
			}
			else {
				p.right = node;
			}
		} 
		else {
			tree = node;
		}
		return tree; 
	}
	
	public static void preorder(Node node) {
		if (node == null) {
			return;
		}
		preorder.add(node.data);
		preorder(node.left);
		preorder(node.right);
	}
	
	public static void postorder(Node node) {
		if (node == null) {
			return;
		}
		postorder(node.left);
		postorder(node.right);
		postorder.add(node.data);
	}
}

class Node {
	int loc_x;
	int loc_y;
	int data;
	Node left;
	Node right;
	public Node(int val, int loc_x, int loc_y) {
		this.data = val;
		this.loc_x = loc_x;
		this.loc_y = loc_y;
	}
}
