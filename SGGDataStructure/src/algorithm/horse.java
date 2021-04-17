package algorithm;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Comparator;

public class horse {
	public static final int X=7;
	public static final int Y=7;
	public static boolean visited[]=new boolean[(X+1)*(Y+1)];
	public static boolean finished;
	public static void main(String[] args) {
		int row=2;
		int col=4;
		int[][]board=new int[X+1][Y+1];
		long before=System.currentTimeMillis();
		traversalChessBoard(board, row-1, col-1,1);
		long end=System.currentTimeMillis();
		System.out.println("共耗时："+(end-before)+"毫秒");
		for(int[]rows:board) {
			for(int cols:rows) {
				System.out.print(cols+"\t");
			}
			System.out.println();
		}
	}
	/**
	 * 
	 * @param board
	 * @param row   马当前的行
	 * @param col   cur col
	 * @param step  第几步，初识为第一步
	 */
	public static void traversalChessBoard(int[][]board,int row,int col,int step) {
		board[row][col]=step;
		visited[row*(X+1)+col]=true;
		ArrayList<Point> ps=next(new Point(col,row));
		sort(ps);
		while(!ps.isEmpty()) {
			Point p=ps.remove(0);
			if(!visited[p.y*(X+1)+p.x]) {
				traversalChessBoard(board, p.y, p.x, step+1);
			}
		}
		if(!finished&&step<(X+1)*(Y+1)) {
			visited[row*(X+1)+col]=false;
			board[row][col]=0;
		}else {
			finished=true;
			System.out.println("finished");
		}
	}
	
	public static ArrayList<Point> next(Point curPoint){
		ArrayList<Point>ps=new ArrayList<Point>();
		Point p1=new Point();
		if((p1.x=curPoint.x-2)>=0&&(p1.y=curPoint.y-1)>=0) {
			ps.add(new Point(p1));
		}
		if((p1.x=curPoint.x-1)>=0&&(p1.y=curPoint.y-2)>=0) {
			ps.add(new Point(p1));
		}
		if((p1.x=curPoint.x+1)<=X&&(p1.y=curPoint.y-2)>=0) {
			ps.add(new Point(p1));
		}
		if((p1.x=curPoint.x+2)<=X&&(p1.y=curPoint.y-1)>=0) {
			ps.add(new Point(p1));
		}
		if((p1.x=curPoint.x+2)<=X&&(p1.y=curPoint.y+1)<=Y) {
			ps.add(new Point(p1));
		}
		if((p1.x=curPoint.x+1)<=X&&(p1.y=curPoint.y+2)<=Y) {
			ps.add(new Point(p1));
		}
		if((p1.x=curPoint.x-1)>=0&&(p1.y=curPoint.y+2)<=Y) {
			ps.add(new Point(p1));
		}
		if((p1.x=curPoint.x-2)>=0&&(p1.y=curPoint.y+1)<=Y) {
			ps.add(new Point(p1));
		}
		return ps;
	}
	
	public static void sort(ArrayList<Point>ps) {
		ps.sort(new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				return next(o1).size()-next(o2).size();
			}
		});
	}

}
