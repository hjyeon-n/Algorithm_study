import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {    
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
	
	static Node insertNode (Node node, int data) {
		Node current = null;
		
        if(node == null) {
            return new Node(data);
        }
        
        if(node.data > data) {
            current = insertNode(node.left, data);
            node.left = current;
        }else {
            current = insertNode(node.right, data);
            node.right = current;
        }
        return node; 
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
