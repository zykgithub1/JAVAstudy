package demo_2021_8_7_graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Dijkstra {
	public static HashMap<Node,Integer> dijkstral(Node head){
		HashMap<Node,Integer>distanceMap=new HashMap<>();
		HashSet<Node>seen=new HashSet();
		distanceMap.put(head, 0);
		seen.add(head);
		Node minNode=getMinDistance(distanceMap,seen);
		while(minNode!=null) {
			int distance=distanceMap.get(minNode);
			for(Edge edge:minNode.edges) {
				Node toNode=edge.to;
				if(!distanceMap.containsKey(toNode)) {
					distanceMap.put(toNode, distance+edge.weight);
				}
				distanceMap.put(toNode, Math.min(distanceMap.get(toNode),distance+edge.weight));
			}
			seen.add(minNode);
			minNode=getMinDistance(distanceMap, seen);
		}
		return distanceMap;
	}

	private static Node getMinDistance(HashMap<Node, Integer> distanceMap, HashSet<Node> seen) {
		int min=Integer.MAX_VALUE;
		Node node=null;
		for(Map.Entry<Node, Integer>entry:distanceMap.entrySet()) {
			if(!seen.contains(entry.getKey())&&entry.getValue()<min) {
				min=entry.getValue();
				node=entry.getKey();
			}
		}
		return node;
	}

}
