package PAT;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PAT4_06 {
	static boolean flag1 = true;
	static boolean flag2 = true;
	static StringBuilder sb = new StringBuilder();

	public static Node GetRoot1(List<Integer> pre) {
		if (pre == null || pre.size() == 0) {
			return null;
		}
		int r = pre.get(0);
		Node root = new Node(r);
		int i = 1;
		for (; i < pre.size(); i++) {
			if (pre.get(i) >= r) {
				break;
			}
		}
		int cut = i;
		for (; i < pre.size(); i++) {
			if (pre.get(i) < r) {
				flag1 = false;
				return null;
			}
		}
		root.left = GetRoot1(pre.subList(1, cut));
		root.right = GetRoot1(pre.subList(cut, pre.size()));
		return root;
	}

	public static Node GetRoot2(List<Integer> pre) {
		if (pre == null || pre.size() == 0) {
			return null;
		}
		int r = pre.get(0);
		Node root = new Node(r);
		int i = 0;
		for (; i < pre.size(); i++) {
			if (pre.get(i) < r) {
				break;
			}
		}
		int cut = i;
		for (; i < pre.size(); i++) {
			if (pre.get(i) >= r) {
				flag2 = false;
				return null;
			}
		}
		root.left = GetRoot2(pre.subList(1, cut));
		root.right = GetRoot2(pre.subList(cut, pre.size()));
		return root;
	}

	public static void PostOrderPrint(Node root) {
		if (root == null) {
			return;
		}
		PostOrderPrint(root.left);
		PostOrderPrint(root.right);
		sb.append(root.element + " ");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedInputStream(System.in));
		int n = sc.nextInt();
		ArrayList<Integer> pre = new ArrayList<Integer>(n);
		for (int i = 0; i < n; i++) {
			pre.add(sc.nextInt());
		}
		sc.close();
		Node root1 = GetRoot1(pre);
		if (flag1 == true) {
			PostOrderPrint(root1);
			System.out.println("YES");
			System.out.println(sb.toString().trim());
			return;
		}
		Node root2 = GetRoot2(pre);
		if (flag2 == true) {
			System.out.println("YES");
			PostOrderPrint(root2);
			System.out.println(sb.toString().trim());
			return;
		}
		System.out.println("NO");
	}

}

class Node {
	int element;
	Node left, right;

	public Node(int element) {
		this.element = element;
		this.left = null;
		this.right = null;
	}
}
