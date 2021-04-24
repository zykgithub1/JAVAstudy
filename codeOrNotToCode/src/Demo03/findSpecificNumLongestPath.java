package Demo03;

import java.util.HashMap;

public class findSpecificNumLongestPath {
	public static void main(String[] args) {
		Node root = creatTree();
//		Demo03.traversalAllApproaches.preOrderRecur(root);
		int longestPath = getMaxLength(root,-9);
		System.out.println(longestPath);

	}

	private static int getMaxLength(Node head, int sum) {
		HashMap<Integer, Integer> sumMap = new HashMap();
		sumMap.put(0, 0);
		return preOrder(head, sum, 0, 1, 0, sumMap);

	}

	private static int preOrder(Node head, int sum, int preSum, int level, int maxLen,
			HashMap<Integer, Integer> sumMap) {
		if (head == null) {
			return maxLen;
		}
		int curSum = preSum + head.value;
		if (!sumMap.containsKey(curSum)) {
			sumMap.put(curSum, level);
		}
		if (sumMap.containsKey(curSum - sum)) {
			maxLen=Math.max(maxLen, level-sumMap.get(curSum-sum));
		}
		maxLen=preOrder(head.left, sum, curSum, level+1, maxLen, sumMap);
		maxLen=preOrder(head.right, sum, curSum, level+1, maxLen, sumMap);
		if(sumMap.get(curSum)==level) {
			sumMap.remove(curSum);
		}
		return maxLen;
	}

	public static Node creatTree() {
		Node root = new Node(-3);
		root.left = new Node(3);
		root.right = new Node(-9);
		root.right.left = new Node(2);
		root.right.right = new Node(1);
		root.left.left = new Node(1);
		root.left.right = new Node(0);
		root.left.right.left = new Node(1);
		root.left.right.right = new Node(6);
		return root;
	}

}
