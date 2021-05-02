package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class trainArrangement {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		TreeSet<Integer> set = new TreeSet();
		for (int i = 0; i < N; i++) {
			int cur = sc.nextInt();
			//�������Ϊ�ջ��߷���ֵ==null��cur���ڼ���������ֵ����ֱ�Ӱ�cur���뼯��
			if (set.size() == 0 || set.ceiling(cur) == null) {
				set.add(cur);
			}else {
				//����ҵ��˴���cur����Сֵ������cur������
				set.remove(set.ceiling(cur));
				set.add(cur);
			}
		}
		//��󼯺ϵĴ�С��Ϊ��Ҫ�Ĺ����
		System.out.println(set.size());
	}
}
