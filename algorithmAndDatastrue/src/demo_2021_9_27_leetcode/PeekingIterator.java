package demo_2021_9_27_leetcode;

import java.util.Iterator;

public class PeekingIterator implements Iterator {
	Iterator<Integer> it;
	Integer nextEle;

	public PeekingIterator(Iterator<Integer> iterator) {
		// initialize any member here.
		it = iterator;
		nextEle = it.next();
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		return nextEle;

	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		Integer ans = nextEle;
		nextEle = it.hasNext() ? it.next() : null;
		return ans;
	}

	@Override
	public boolean hasNext() {
		return nextEle != null;
	}

}
