package selfTestFirstChapter;

public class testBreak {
	public static void main(String[] args) {
		int i=0;
		int j=0;
		while(i<10) {
			while(j<10) {
				System.out.println("j="+j);
				if(j==5) {
					break ;
				}
				j++;
			}
			System.out.println("i="+i+"  "+"j="+j);
			i++;
		}
	}

}
