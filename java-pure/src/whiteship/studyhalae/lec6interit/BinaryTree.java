package whiteship.studyhalae.lec6interit;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

	static class Node {
		private int value;
		private Node leftNode;
		private Node rightNode;

		public Node(int value) {
			this.value = value;
		}

		public Node(int value, Node leftNode, Node rightNode) {
			this.value = value;
			this.leftNode = leftNode;
			this.rightNode = rightNode;
		}

		public int getValue() {
			return value;
		}

		public Node getLeftNode() {
			return leftNode;
		}

		public Node getRightNode() {
			return rightNode;
		}
	}

	public static void main(String[] args) {
		Node root = getNode();
		System.out.println("DFS: ");
		BinaryTree.searchByDfs(root);
		System.out.println("\n\nBFS: ");
		BinaryTree.searchByBfs(root);
		System.out.println();
	}

	private static void searchByBfs(Node node) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(node);
		do {
			Node poll = queue.poll();
			if (poll == null) {
				continue;
			}
			System.out.print(poll.getValue() + " ");
			Node leftNode = poll.getLeftNode();

			if (leftNode != null) {
				queue.offer(leftNode);
			}

			Node rightNode = poll.getRightNode();
			if (rightNode != null) {
				queue.offer(rightNode);
			}
		} while (!queue.isEmpty());
	}

	private static Node getNode() {
		Node leftOfLeftOfLeftNode = new Node(1);
		Node leftOffLeftNode = new Node(2, leftOfLeftOfLeftNode, null);
		Node rightOfLeftNode = new Node(4);
		Node leftNode = new Node(3, leftOffLeftNode, rightOfLeftNode);

		Node rightOfLeftOfRightNode = new Node(9);
		Node leftOfRightNode = new Node(8, null, rightOfLeftOfRightNode);
		Node rightOfRightNode = new Node(10, null, null);
		Node rightNode = new Node(7, leftOfRightNode, rightOfRightNode);

		Node root = new Node(5, leftNode, rightNode);
		return root;
	}

	private static void searchByDfs(Node node) {
		System.out.print(node.getValue() + " ");
		Node leftNode = node.getLeftNode();
		Node rightNode = node.getRightNode();
		if (leftNode != null) {
			searchByDfs(leftNode);
		}
		if (rightNode != null) {
			searchByDfs(rightNode);
		}
	}
}
