import java.util.Scanner;
public class TestLfElseLfElse {
	public static void main(String[]args) {

		int n=10;
		for(n=10;n>=0;n--) {
			System.out.println("�������������");
			Scanner scanner=new Scanner(System.in);
			
			int age=scanner.nextInt();
			System.out.println(age);
			if(age<15) {
				System.out.println("Сƨ�������");
			}else if(age<25) {
				System.out.println("�����˶�ѧϰ");
			}else if(age<45) {
				System.out.println("�˵����겻����");
			}else if(age<65) {
				System.out.println("��ʿĺ�꣬׳�Ĳ���");
			}else if(age<85) {
				System.out.println("�������");
			}else {
				System.out.println("������");
			}
		}
	}

}
