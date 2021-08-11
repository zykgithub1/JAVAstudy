package demo_2021_8_11;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import demo_2021_8_11.unionFind.UnionFind;

public class unionFind<V> {
	public static void main(String[] args) {
		UnionFind unionFind = new UnionFind<Character>(null);
	}

	public static class Element<V> {
		public V value;

		public Element(V value) {
			this.value = value;
		}
	}

	public static class UnionFind<V> {
		public HashMap<V, Element<V>> elementMap;
		public HashMap<Element<V>, Element<V>> fatherMap;
		public HashMap<Element<V>, Integer> sizeMap;

		public UnionFind(List<V> list) {
			elementMap = new HashMap();
			fatherMap = new HashMap();
			sizeMap = new HashMap();
			for (V value : list) {
				Element<V> element = new Element<>(value);
				elementMap.put(value, element);
				fatherMap.put(element, element);
				sizeMap.put(element, 1);
			}
		}

		public boolean isSameSet(V a, V b) {
			if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
				return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
			}
			return false;
		}

		public void union(V a, V b) {
			if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
				Element<V> af = findHead(elementMap.get(a));
				Element bf = findHead(elementMap.get(a));
				if (af != bf) {
					Element big = sizeMap.get(af) >= sizeMap.get(bf) ? af : bf;
					Element small = big == af ? bf : af;
					sizeMap.put(big, sizeMap.get(small) + sizeMap.get(big));
					fatherMap.put(small, big);
					sizeMap.remove(small);
				}
			}
		}

		private Element findHead(Element<V> element) {
			Stack<Element> stack = new Stack();
			while (fatherMap.get(element) != element) {
				stack.push(element);
				element = fatherMap.get(element);
			}
			while (!stack.isEmpty()) {
				fatherMap.put(stack.pop(), element);
			}
			return element;
		}
	}

}
