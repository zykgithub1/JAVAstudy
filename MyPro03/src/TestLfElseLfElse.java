import java.util.Scanner;
public class TestLfElseLfElse {
	public static void main(String[]args) {

		int n=10;
		for(n=10;n>=0;n--) {
			System.out.println("请输入你的年龄");
			Scanner scanner=new Scanner(System.in);
			
			int age=scanner.nextInt();
			System.out.println(age);
			if(age<15) {
				System.out.println("小屁孩多喝奶");
			}else if(age<25) {
				System.out.println("年轻人多学习");
			}else if(age<45) {
				System.out.println("人到中年不得已");
			}else if(age<65) {
				System.out.println("烈士暮年，壮心不已");
			}else if(age<85) {
				System.out.println("真的老了");
			}else {
				System.out.println("老寿星");
			}
		}
	}

}
