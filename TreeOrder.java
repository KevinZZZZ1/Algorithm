package tree;

import java.util.Stack;


//public class Node {
//	public int value;
//	public Node left;
//	public Node right;
//	public Node(int val) {
//		this.value = val;
//	}
//}

public class TreeOrder {
	public static void preOrderTree(Node root) {
		// 递归先序遍历：根左右
		if(root==null)
			return;
		System.out.println(root.value);
		preOrderTree(root.left);
		preOrderTree(root.right);
	}
	
	public static void inOrderTree(Node root) {
		// 递归中序遍历：左根右
		if(root == null)
			return;
		inOrderTree(root.left);
		System.out.println(root.value);
		inOrderTree(root.right);
		
	}
	
	public static void postOrderTree(Node root) {
		// 递归后序遍历：左右根
		if(root==null)
			return;
		postOrderTree(root.left);
		postOrderTree(root.right);
		System.out.println(root.value);
	}
	
	
	public static void preOrderTreeNonRecur(Node root) {
		if(root==null)
			return;
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		while(!stack.empty()) {
			Node cur = stack.pop();
			System.out.println(cur.value);
			// 由于前序遍历是根左右，所以先将右孩子放入栈中，再把左孩子放入栈中
			if(cur.right!=null)
				stack.push(cur.right);
			if(cur.left!=null)	
				stack.push(cur.left);
		}
	}
	
	
	public static void inOrderTreeNonRecur(Node root) {
		if(root==null)
			return;
		Stack<Node> stack = new Stack<Node>();
		Node cur = root;
		while(!stack.empty() || cur!=null) {
			if(cur!=null) {
				stack.push(cur);
				cur = cur.left;
			}
			else {
				cur = stack.pop(); // 最左边的一个结点
				System.out.println(cur.value);
				cur = cur.right;// 最左结点的右结点
			}

		}
		
	}
	
	public static void postOrderTreeNonRecur(Node root) {
		// 两个栈实现后序遍历
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		s1.push(root);
		while(!s1.empty()) {
			
			Node cur = s1.pop();
			if(cur.left!=null)
				s1.push(cur.left);
			if(cur.right!=null)
				s1.push(cur.right);
			
			s2.push(cur); // 将s1弹出的元素放入s2中
		}
		
		while(!s2.empty())
			System.out.println(s2.pop().value);
	}
	
	
	public static void postOrderTreeNonRecur_2(Node root) {
		// 使用一个栈完成后序遍历
		
		if(root==null)
			return;
		
		Stack<Node> stack = new Stack<Node>();
		Node h=root;// 表示最近一次弹出并打印的结点
		Node c=null;// 代表stack的栈顶结点
		stack.push(h);
		while(!stack.empty()) {
			c = stack.peek();
			if(c.left!=null && h!=c.left && h!=c.right) {
				stack.push(c.left);
			}else if(c.right!=null && h!=c.right) {
				stack.push(c.right);
			}else {
				System.out.println(stack.pop().value);
				h = c;
			}
		}
	}
	
	
	public static void main(String[] args) {
		Node root = new Node(1);
		Node node1 = new Node(2);
		Node node2 = new Node(3);
		Node node3 = new Node(4);
		Node node4 = new Node(5);
		Node node5 = new Node(6);
		Node node6 = new Node(7);
		
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		
		
		postOrderTreeNonRecur(root);
		System.out.println();
		postOrderTree(root);
		
		
	}
}
