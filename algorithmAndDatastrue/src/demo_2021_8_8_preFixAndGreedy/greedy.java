package demo_2021_8_8_preFixAndGreedy;

import java.util.Arrays;
import java.util.Comparator;

public class greedy {

	public static class Program {
		public int start;
		public int end;

		public Program(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
	}

	public static int bestArrange(Program[] programs, int timePoint) {
		Arrays.sort(programs, new Comparator<Program>() {
			@Override
			public int compare(Program o1, Program o2) {
				return o1.end - o2.end;
			}
		});
		int ans=0;
		for(int i=0;i<programs.length;i++) {
			if(programs[i].start>=timePoint) {
				ans++;
				timePoint=programs[i].end;
			}
		}
		return ans;
	}

}
