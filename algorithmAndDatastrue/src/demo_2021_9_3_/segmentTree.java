package demo_2021_9_3_;

public class segmentTree {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		segmentTree sg = new segmentTree(arr);
		sg.build(0, arr.length, 1);
	}

	private int MAXN;
	public int[] sum;
	private int[] arr;
	private int[] lazy;
	private int[] change;
	private boolean[] update;

	public segmentTree(int[] origin) {
		MAXN = origin.length + 1;
		arr = new int[MAXN];
		for (int i = 1; i < MAXN; i++) {
			arr[i] = origin[i - 1];
		}
		sum = new int[MAXN << 2];
		lazy = new int[MAXN << 2];
		change = new int[MAXN << 2];
		update = new boolean[MAXN << 2];
	}

	public void build(int l, int r, int loc) {
		if (l == r) {
			sum[loc] = arr[l];
			return;
		}
		int mid = (r + l) >> 1;
		build(l, mid, loc << 1);
		build(mid + 1, r, loc << 1 | 1);
		pushUp(loc);
	}

	public void pushDown(int rt, int ln, int rn) {
		if (update[rt]) {
			update[rt << 1] = true;
			update[rt << 1 | 1] = true;
			change[rt << 1] = change[rt];
			change[rt << 1 | 1] = change[rt];
			lazy[rt << 1] = 0;
			lazy[rt << 1 | 1] = 0;
			sum[rt << 1] = change[rt] * ln;
			sum[rt << 1 | 1] = change[rt] * rn;
			update[rt] = false;
		}
		if (lazy[rt] != 0) {
			lazy[rt << 1] += lazy[rt];
			sum[rt << 1] += lazy[rt] * ln;
			lazy[rt << 1 | 1] += lazy[rt];
			sum[rt << 1 + 1] += lazy[rt] * rn;
			lazy[rt] = 0;
		}
	}

	public void add(int L, int R, int C, int l, int r, int rt) {
		if (L <= l && r <= R) {
			lazy[rt] += C;
			sum[rt] += C * (r - l + 1);
			return;
		}
		int mid = (r + l) >> 1;
		pushDown(rt, mid - l + 1, r - mid);
		if (L <= mid) {
			add(L, R, C, l, mid, rt << 1);
		}
		if (R > mid) {
			add(L, R, C, mid + 1, r, rt << 1 | 1);
		}
		pushUp(rt);
	}
	
	public long query(int L,int R,int C,int l,int r,int rt) {
		if(L<=l&&r<=R) {
			return sum[rt];
		}
		int mid=(l+r)>>1;
		pushDown(rt, mid-l+1, r-mid);
		long ans=0;
		if(L<=mid) {
			ans+=query(L, R, C, l, mid, rt<<1);
		}
		if(R>mid) {
			ans+=query(L, R, C, mid+1, r, rt<<1|1);
		}
		return ans;
	}

	public void update(int L, int R, int C, int l, int r, int rt) {
		if (L <= l && r <= R) {
			update[rt] = true;
			change[rt] = C;
			sum[rt] = (r - l + 1) * C;
			lazy[rt] = 0;
			return;
		}
		int mid = (r + l) >> 1;
		pushDown(rt, mid - l + 1, r - mid);
		if (L <= mid) {
			update(L, R, C, l, mid, rt);
		}
		if (R > mid) {
			update(L, R, C, mid + 1, r, rt);
		}

	}

	private void pushUp(int loc) {
		sum[loc] = sum[loc << 1] + sum[loc << 1 | 1];
	}
}
