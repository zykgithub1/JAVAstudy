import java.util.Scanner;



public class Tests {
	public static void main(String[]agrs) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入你的名字：");
		String name=sc.nextLine();
		System.out.println("请输入你的爱好");
		String like=sc.nextLine();
		System.out.println("请输入你的年龄");
		int age=sc.nextInt();
		
		
		System.out.println("========================================");
		System.out.println(name);
		System.out.println(like);
		System.out.println(age);
		
	}
	

}
