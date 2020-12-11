
public class User4 {
	int id;
	String name;
	String pwd;
	public User4(int id,String name) {
		this.id=id;
		this.name=name;
	}

	public void testTrans(User4 u) {
		u.name="搞笑吧";
	}
	
	
	public void testTrans1(User4 u) {
			u=new User4(100,"爱爱爱");//对象是新的 所以改变的是新的对象的值而不是以前的u1;
	}
	public static void main(String[]a) {
		User4 u1=new User4(100,"高小七");
		u1.testTrans(u1);
		System.out.println(u1.name);
		u1.testTrans1(u1);
		System.out.println(u1.name);
	}
}
