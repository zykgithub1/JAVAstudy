package PTA2021_5_30;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class leetcode7_5 {
	public int jump(int[] nums) {
		int n = nums.length;
		if (n == 1) {
			return 0;
		}
		Deque<Integer> que = new LinkedList();
		HashSet<Integer> seen = new HashSet();
		que.add(0);
		int ans = 0;
		while (!que.isEmpty()) {
			int size = que.size();
			for (int i = 0; i < size; i++) {
				int cur = que.pollFirst();
				int key = nums[cur];
				while (key != 0) {
					if (seen.contains(cur + key)) {
						key--;
						continue;
					}
					if (cur + key >= n - 1) {
						return ans + 1;
					}
					que.addLast(cur + key);
					seen.add(cur + key);
					key--;
				}
			}
			ans++;
		}
		return ans;

	}

	public boolean canJump(int[] nums) {
		int k = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i > k)
				return false;
			k = Math.max(k, i + nums[i]);
		}
		return true;

	}

}
