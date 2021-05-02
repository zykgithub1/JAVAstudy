package IO.demo01;

import java.io.File;
import java.util.Scanner;

/**
 * 
 * @author lenovo 从键盘输入一个文件夹路径 如果录入的不存在，给予提示 如果录入的是文件路径，给予提示 如果是文件夹路径直接返回
 *
 *         * 递归打印该文件夹下所有的.java文件名 1，获取到该文件夹路径下的所有文件和文件夹，存储在File数组中
 *         2，遍历数组，对每个文件或文件夹进行判断 3.如果是文件，而且后缀是.java就打印 4.如果是文件夹就递归调用
 */
public class fileRecursion {
	public static int count = 0;

	public static void main(String[] args) {
		File dir = getDir();
		printJavaFile(dir);
		System.out.println(count);

	}

	public static File getDir() {
		Scanner sc = new Scanner(System.in);
		System.out.println("please input a source path");
		while (true) {
			String line = sc.nextLine();
			File dir = new File(line);
			if (!dir.exists()) {
				System.out.println("输入的文件夹路径不存在，重新输入");
			} else if (dir.isFile()) {
				System.out.println("你输入的是文件路径，请输入文件夹路径");
			} else {
				return dir;
			}
		}
	}

	public static void printJavaFile(File dir) {
		// 1,获取该文加下所有文件夹
		File[] subFiles = dir.listFiles();
		// 2，遍历数组 如果是.java就打印
		for (File subFile : subFiles) {
			if (subFile.isFile() && subFile.getName().endsWith(".java")) {
				count++;
				System.out.println(subFile);
			} else {
				// 如果是文件夹 就递归调用
				if (subFile.isDirectory()) {
					printJavaFile(subFile);
				}
			}
		}
	}
}
