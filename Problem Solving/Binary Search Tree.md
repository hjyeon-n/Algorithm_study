# Binary Search Tree

### 삽입과 삭제

```java
public class Tree {

    static Node root;

    public static void main(String[] args) {
        Tree tree = new Tree();
        root = null;

        tree.insertNode(3);
        tree.insertNode(80);
        tree.insertNode(19);
        tree.insertNode(8);
        tree.insertNode(24);
        tree.insertNode(31);
        tree.insertNode(2);

        System.out.println("삽입 결과");
        tree.display(root);

        tree.deleteNode(31);
        tree.deleteNode(8);
        
        System.out.println("");
        System.out.println("삭제 결과");
        tree.display(root);
    }

    // 출력은 중위순회
    public void display(Node node) {
        if (node != null) {
            display(node.left);
            System.out.print(node.data + " ");
            display(node.right);
        }
    }

    public void insertNode(int key) {
        Node newNode = new Node(key);

        if (root == null) {
            root = newNode;
            return;
        }

        Node current = root;
        Node prev = null;

        while (current != null) {
            prev = current;

            if (key == current.data) {
                return;
            }
            else if (key < current.data) {
                current = current.left;
            }
            else {
                current = current.right;
            }
        }
        
        if (key < prev.data) {
            prev.left = newNode;
        }
        else {
            prev.right = newNode;
        }
    }

    public void deleteNode (int key) {
        Node prev = null;
        Node current = root;

        while (current != null && current.data != key) {
            prev = current;
            if (key < current.data) {
                current = current.left;
            }

            if (key > current.data) {
                current = current.right;
            }
        }

        if (current == null) {
            System.out.println("data is not in the tree");
            return;
        }

        // 단말노드인 경우
        if (current.left == null && current.right == null) {
            if (prev != null) {
                if (prev.left == current) {
                    prev.left = null;
                }
                else {
                    prev.right = null;
                }
            }
            else {
                root = null;
            }
        }

        // 하나의 자식만 가지는 경우
        else if (current.left == null || current.right == null) {
            Node child = (current.left != null) ? current.left : current.right;
            if (prev != null) {
                if (prev.left == current) {
                    prev.left = child;
                }
                else {
                    prev.right = child;
                }
            }
            else {
                root = child;
            }
        }
        
        // 두 개의 자식을 가지는 경우
        else {
            // 오른쪽 서브트리에서 successor를 찾는다.
            Node succ_p = current;
            Node succ = current.right;

            while (succ.left != null) {
                succ_p = succ;
                succ = succ.left;
            }

            if (succ_p.left == succ) {
                succ_p.left = succ.right;
            }
            else {
                succ_p.right = succ.right;
            }

            current.data = succ.data;
            current = succ;
        }
    }

    class Node {
        int data;
        Node left;
        Node right;
    
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
```

