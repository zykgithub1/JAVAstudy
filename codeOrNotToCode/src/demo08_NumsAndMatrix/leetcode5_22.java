package demo08_NumsAndMatrix;

import java.util.ArrayList;
import java.util.List;

public class leetcode5_22 {
	public static void main(String[] args) {
		
	}

}

class Solution3 {

	public List<Integer> countSmaller(int[] nums) {
		List<Integer> result = new ArrayList<>();
		int len = nums.length;
		if (len == 0) {
			return result;
		}

		int[] temp = new int[len];
		int[] res = new int[len];

		// �������飬���ã��鲢��ȥ��ʱ�򣬷���֪�����ĸ��±��Ԫ��
		int[] indexes = new int[len];
		for (int i = 0; i < len; i++) {
			indexes[i] = i;
		}
		mergeAndCountSmaller(nums, 0, len - 1, indexes, temp, res);

		// �� int[] ת����Ϊ List<Integer>��û��ҵ���߼�
		for (int i = 0; i < len; i++) {
			result.add(res[i]);
		}
		return result;
	}

	/**
	 * ������� nums ָ�������� [left, right] ���й鲢����������Ĺ��������ͳ������
	 *
	 * @param nums
	 * @param left
	 * @param right
	 */
	private void mergeAndCountSmaller(int[] nums, int left, int right, int[] indexes, int[] temp, int[] res) {
		if (left == right) {
			return;
		}
		int mid = left + (right - left) / 2;
		mergeAndCountSmaller(nums, left, mid, indexes, temp, res);
		mergeAndCountSmaller(nums, mid + 1, right, indexes, temp, res);

		// �鲢������Ż�������������������򲻴��������ϵ��û�б�Ҫ�ϲ�
		if (nums[indexes[mid]] <= nums[indexes[mid + 1]]) {
			return;
		}
		mergeOfTwoSortedArrAndCountSmaller(nums, left, mid, right, indexes, temp, res);
	}

	/**
	 * [left, mid] ���ź���ģ�[mid + 1, right] ���ź����
	 *
	 * @param nums
	 * @param left
	 * @param mid
	 * @param right
	 * @param indexes
	 * @param temp
	 * @param res
	 */
	private void mergeOfTwoSortedArrAndCountSmaller(int[] nums, int left, int mid, int right, int[] indexes, int[] temp,
			int[] res) {
		for (int i = left; i <= right; i++) {
			temp[i] = indexes[i];
		}

		int i = left;
		int j = mid + 1;
		for (int k = left; k <= right; k++) {
			if (i > mid) {
				indexes[k] = temp[j];
				j++;
			} else if (j > right) {
				indexes[k] = temp[i];
				i++;
				res[indexes[k]] += (right - mid);
			} else if (nums[temp[i]] <= nums[temp[j]]) {
				// ע�⣺������ <= ����֤�ȶ���
				indexes[k] = temp[i];
				i++;
				res[indexes[k]] += (j - mid - 1);
			} else {
				indexes[k] = temp[j];
				j++;
			}
		}
	}
}
