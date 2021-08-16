package demo_2021_8_14_treeDpAndMorris;

import java.util.ArrayList;
import java.util.List;

public class maxHappiness {
	public static void main(String[] args) {
		Employee boss = new Employee(5);

		Employee f1 = new Employee(100);
		Employee f2 = new Employee(3);
		Employee f3 = new Employee(7);
		Employee s1 = new Employee(5);
		Employee s2 = new Employee(60);
		Employee s3 = new Employee(4);
		boss.subordinate.add(f1);
		boss.subordinate.add(f2);
		boss.subordinate.add(f3);
		f1.subordinate.add(s1);
		f2.subordinate.add(s2);
		f3.subordinate.add(s3);
		System.out.println(getMaxHappy(boss));
		System.out.println(treeDp(boss));
	}

	public static class Employee {
		public int happy;
		List<Employee> subordinate;

		public Employee(int happy) {
			this.happy = happy;
			subordinate = new ArrayList();
		}

	}

	public static int getMaxHappy(Employee boss) {
		return Math.max(process(boss, true), process(boss, false));
	}

	private static int process(Employee boss, boolean come) {
		int ans = 0;
		if (come == true) {
			ans += boss.happy;
			for (Employee emp : boss.subordinate) {
				ans += process(emp, false);
			}
		} else {
			for (Employee emp : boss.subordinate) {
				ans += getMaxHappy(emp);
			}
		}
		return ans;
	}

	public static class Info {
		public int comeMaxHappy;
		public int NoMaxHappy;

		public Info(int yes, int no) {
			comeMaxHappy = yes;
			NoMaxHappy = no;
		}
	}

	public static int treeDp(Employee boss) {
		return Math.max(treeDpWay(boss).comeMaxHappy, treeDpWay(boss).NoMaxHappy);
	}

	public static Info treeDpWay(Employee boss) {
		if (boss.subordinate.isEmpty()) {
			return new Info(boss.happy, 0);
		}
		int lai = boss.happy;
		int bulai = 0;
		for (Employee next : boss.subordinate) {
			Info nextInfo = treeDpWay(next);
			lai += nextInfo.NoMaxHappy;
			bulai += Math.max(nextInfo.comeMaxHappy, nextInfo.NoMaxHappy);
		}
		return new Info(lai, bulai);
	}

}
