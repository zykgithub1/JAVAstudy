package Astart;

enum E_node{
	Wlak,
	Stop;
}


public class AstartNode {
	//Ѱ·����
	public float f;
	//���յ����
	public float h;
	//��������
	public float g;
	//������
	public AstartNode father;
	public int x;
	public int y;
	public E_node type;
	/**
	 * 
	 * @param x ��������͸�������
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
