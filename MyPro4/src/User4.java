
public class User4 {
	int id;
	String name;
	String pwd;
	public User4(int id,String name) {
		this.id=id;
		this.name=name;
	}

	public void testTrans(User4 u) {
		u.name="��Ц��";
	}
	
	
	public void testTrans1(User4 u) {
			u=new User4(100,"������");//�������µ� ���Ըı�����µĶ����ֵ��������ǰ��u1;
	}
	public static void main(String[]a) {
		User4 u1=new User4(100,"��С��");
		u1.testTrans(u1);
		System.out.println(u1.name);
		u1.testTrans1(u1);
		System.out.println(u1.name);
	}
}
