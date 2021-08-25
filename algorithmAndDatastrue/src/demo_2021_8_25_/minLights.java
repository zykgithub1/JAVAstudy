package demo_2021_8_25_;

public class minLights {
	public static void main(String[] args) {
		String s=".X..X..XXX....XXX...X.X.X.X";
		System.out.println(minLight(s));
		
	}
	
	public static int minLight(String s) {
		char[]chs=s.toCharArray();
		int index=0;
		int lights=0;
		int n=chs.length;
		while(index<n) {
			if(chs[index]=='X') {
				index++;
			}else {
				lights++;
				if(index+1==n) {
					break;
				}else {
					//   ....X.XXX...X
					if(chs[index+1]=='X') {
						index=index+2;
					}else {
						index=index+3;
					}
				}
			}
		}
		return lights;
	}

}
