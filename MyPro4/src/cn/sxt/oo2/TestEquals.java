package cn.sxt.oo2;

public class TestEquals {
	public static void main(String[]a) {
		Object obj;
		String str;
		User u1=new User(1000,"zyk","123456");
		User u2=new User(1000,"zyk","123456");
		System.out.println(u1.equals(u2));
		System.out.println(u1==u2);
	}
}
class User{
	int id;
	String name;
	String pwd;
	public User(int id, String name, String pwd) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}

