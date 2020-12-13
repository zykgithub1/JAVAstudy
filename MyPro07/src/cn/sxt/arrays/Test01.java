package cn.sxt.arrays;

public class Test01 {
	public static void main(String[]a) {
		int[] arr01=new int[10];
		String[] arr02=new String[5];
		arr01[0]=13;
		for(int i=0;i<arr01.length;i++) {
			arr01[i]=(int)(Math.random()*100);
		}
		for(int i=0;i<arr01.length;i++) {
			System.out.println(arr01[i]);
		}
		User[] arr03=new User[5];
		arr03[0]=new User(1,"zy");
		arr03[1]=new User(2,"zyk");
		arr03[2]=new User(3,"zykk");
		arr03[3]=new User(4,"zykkk");
		arr03[4]=new User(5,"zykkkk");
		for(int i=0;i<arr03.length;i++) {
			System.out.println(arr03[i].getName());
		}
	}

}
class User{
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	
	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}