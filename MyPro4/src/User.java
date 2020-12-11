
public class User {

	int id;
    String name;
	String pwd;
	
	public User() {
		
	}
	public User(int id,String name) {
		this.id=id;
		this.name=name;
	}
	
	public static void main(String[]a) {
		User a1=new User();
		User a2=new User(2112,"zydk");
		System.out.println(a2.id);
		System.out.println(a2.name);
	}
}
