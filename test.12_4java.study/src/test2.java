
public class test2 {

	public static void main(String[]arge) {
		Scanner input=new Scanner(System.in);
		System.out.println("ÇëÊäÈë²ãÊı");
		int s=input.nextInt();
		int k,i,n=1,a,b;
		k=(s-1)/2;
		for(i=0;i<(s+1)/2;i++) {
			for(i=0;i<(s+1)/2;i++)
			{
				System.out.println(" ");
			}
			for(b=0;b<n;b++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
		k=k-1;
		n=n+2;
		for(i=(s+1)/2;i<s;i++)
		{
			for(a=0;a<k;a++)
			{
				System.out.println(" ");
			}
			System.out.print("\n");
			k=k+1;
			n=n-2;
		}
		
	}
}
