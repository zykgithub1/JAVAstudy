import java.util.Scanner;

public class test {
	public static void main(String[]arge) {
		int s=1;
		Scanner input=new Scanner(System.in);
		System.out.println("��������Ҫ�������ַ���Ĳ�����");
		int n=input.nextInt();
		int[][] a=new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++)
			{
				a[i][j]=s;
				s++;
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.println(a[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
