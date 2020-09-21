import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class 5639_ver1 {    
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Node root = new Node(n);
		String str = "";
		while ((str = br.readLine()) != null && str.length() != 0) {
			root = insertNode(root, Integer.parseInt(str));
		}
		postorder(root);
	}
	
	static Node insertNode (Node root, int value) {
		Node t = root; // 삽입할 위치
		Node p = null; // 상위 노드 참조

		while(t != null){
			if(t.data == value) {
				return t;
			}

			p = t;

			if(p.data > value) {
				t = p.left;
			}
			else {
				t = p.right;
			}
		}

		Node node = new Node(value);

		if(p != null){ 
			if(p.data > value) {
				p.left = node;
			}
			else {
				p.right = node;
			}
		} 
		else {
			root = node;
		}
		return root; 
	}
	
	public static void postorder(Node node) {
		if (node == null) {
			return;
		}
		postorder(node.left);
		postorder(node.right);
		System.out.println(node.data);
	}
}

class Node {
	int data;
	Node left;
	Node right;
	public Node(int val) {
		this.data = val;
	}
}
