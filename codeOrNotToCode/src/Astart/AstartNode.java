package Astart;

enum E_node{
	Wlak,
	Stop;
}


public class AstartNode {
	//寻路消耗
	public float f;
	//离终点距离
	public float h;
	//离起点距离
	public float g;
	//父对象
	public AstartNode father;
	public int x;
	public int y;
	public E_node type;
	/**
	 * 
	 * @param x 传入坐标和格子类型
	 * @param y
	 * @param type
	 */
	public AstartNode(int x, int y, E_node type) {
		super();
		this.x = x;
		this.y = y;
		this.type = type;
	}
	
	public void clearSelf() {
		this.f=0;
		this.g=0;
		this.h=0;
	}
}
