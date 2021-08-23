package demo_2021_8_23;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class JobAssignment {
	public static void main(String[] args) {
		
	}

	public static class job {
		public int hard;
		public int money;

		public job(int hard, int money) {
			super();
			this.hard = hard;
			this.money = money;
		}
	}

	public static int[] getMoneys(job[] jobs, int[] ability) {
		Arrays.sort(jobs, new Comparator<job>() {
			@Override
			public int compare(job o1, job o2) {
				return o1.hard != o2.hard ? (o1.hard - o2.hard) : (o2.money - o1.money);
			}
		});
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		map.put(0, jobs[0].money);
		job pre = jobs[0];
		for (int i = 1; i < jobs.length; i++) {
			if (pre.money > jobs[i].money && pre.hard != jobs[i].hard) {
				map.put(i, jobs[i].money);
				pre = jobs[i];
			}
		}
		int ans[] = new int[ability.length];
		for (int i = 0; i < ans.length; i++) {
			Integer key = map.floorKey(ability[i]);
			ans[i] = key != null ? map.get(key) : 0;
		}
		return ans;
	}

}
