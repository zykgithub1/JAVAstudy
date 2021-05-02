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
			//如果集合为空或者返回值==null（cur大于集合中所有值），直接把cur加入集合
			if (set.size() == 0 || set.ceiling(cur) == null) {
				set.add(cur);
			}else {
				//如果找到了大于cur的最小值，就用cur更新它
				set.remove(set.ceiling(cur));
				set.add(cur);
			}
		}
		//最后集合的大小即为需要的轨道数
		System.out.println(set.size());
	}
}
