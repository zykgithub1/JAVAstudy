package Astart;

import java.awt.Point;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class test {

	public static void main(String[] args) {
		PriorityQueue<AstartNode> pq = new PriorityQueue<AstartNode>(new Comparator<AstartNode>() 
		{
			@Override
			public int compare(AstartNode o1,AstartNode o2) {
				return (int)(o1.f-o2.f);
			}
		});
		PriorityQueue<AstartNode> p = new PriorityQueue<AstartNode>((a,b)->(int)(a.f-b.f));
		
		AstartMgr asm=new AstartMgr();
		asm.InitMapInfo(100, 110);
		System.out.println(asm.nodes);
//		for(int i=0;i<5;i++) {
//			for(int j=0;j<5;j++) {
//				System.out.println(asm.nodes[i][j].type);
//			}
//		}
		List<AstartNode> findPath= asm.FindPath(new Point(1,1),new Point(66,76));
		if(findPath!=null) {
			for(AstartNode asnode:findPath) {
				System.out.println(asnode.x+"----"+asnode.y+"这是一步");
			}
		}
		
	}

}
