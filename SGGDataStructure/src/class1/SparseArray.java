package class1;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class SparseArray {
	public static void main(String[] args) {
		int[][] chessArray = new int[11][11];
		chessArray[1][2] = 1;
		chessArray[2][3] = 2;
		chessArray[5][6] = 2;
		chessArray[4][3] = 1;
		chessArray[3][7] = 1;
		chessArray[5][9] = 1;
		// display(chessArray);
		int[][]readSprase=readFile();
		display(chessArray);
		int[][] sparseArray = generate(chessArray);
		int[][] SparseToChessArray = reverse(sparseArray);
		display(SparseToChessArray);
	}

	private static int[][] readFile() {
		FileReader reader=null;
		BufferedReader bfr=null;
		int[][]chessArray=null;
		try {
			reader=new FileReader("sparseArray.txt");
			bfr=new BufferedReader(reader);
			List<String> list=new ArrayList<>();
			String lineStr;
			if((lineStr=bfr.readLine())!=null) {
				list.add(lineStr);
			}
			chessArray=new int[list.size()][3];
			int count=0;
			for(String str:list) {
				String[] strs=str.split("\\,");
				chessArray[count][0]=Integer.valueOf(strs[0]);
				chessArray[count][1]=Integer.valueOf(strs[1]);
				chessArray[count][2]=Integer.valueOf(strs[2]);
				count++;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(reader!=null) {
					reader.close();
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(bfr!=null) {
					bfr.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return chessArray;
	}

	private static int[][] reverse(int[][] spar) {
		int[][] ans = new int[spar[0][0]][spar[0][1]];
		for (int i = 1; i < spar.length; i++) {
			ans[spar[i][0]][spar[i][1]] = spar[i][2];
		}
		return ans;
	}

	private static void display(int[][] chessArray) {
		for (int[] chess : chessArray) {
			for (int i : chess) {
				System.out.printf("%d ", i);
			}
			System.out.println();
		}

	}

	private static int[][] generate(int[][] chessArray) {
		int sum = 0;
		for (int i = 0; i < chessArray.length; i++) {
			for (int j = 0; j < chessArray[0].length; j++) {
				if (chessArray[i][j] != 0) {
					sum++;
				}
			}
		}
		int[][] ans = new int[sum + 1][3];
		ans[0][0] = chessArray.length;
		ans[0][1] = chessArray[0].length;
		ans[0][2] = sum;
		int count = 0;
		for (int i = 0; i < chessArray.length; i++) {
			for (int j = 0; j < chessArray[0].length; j++) {
				if (chessArray[i][j] != 0) {
					count++;
					ans[count][0] = i;
					ans[count][1] = j;
					ans[count][2] = chessArray[i][j];
				}
			}
		}
		display(ans);
		saveParse(ans);
		return ans;
	}

	private static void saveParse(int[][] ans) {
		FileWriter writeFile=null;
		try {
			File file=new File("sparseArray.txt");
			if(!file.exists()) {
				file.createNewFile();
			}
			writeFile=new FileWriter(file);
			for(int i=0;i<ans.length;i++) {
				for(int j=0;j<2;j++) {
					writeFile.write(ans[i][j]+",");
				}
				writeFile.write(ans[i][2]+"");
				writeFile.write("\n");
			}
			writeFile.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{
				if(writeFile!=null) {
					writeFile.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		
	}
	
	
}
