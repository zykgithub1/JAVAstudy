package IO.demo01;

import java.io.File;
import java.util.Scanner;

/**
 * 
 * @author lenovo �Ӽ�������һ���ļ���·�� ���¼��Ĳ����ڣ�������ʾ ���¼������ļ�·����������ʾ ������ļ���·��ֱ�ӷ���
 *
 *         * �ݹ��ӡ���ļ��������е�.java�ļ��� 1����ȡ�����ļ���·���µ������ļ����ļ��У��洢��File������
 *         2���������飬��ÿ���ļ����ļ��н����ж� 3.������ļ������Һ�׺��.java�ʹ�ӡ 4.������ļ��о͵ݹ����
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
				System.out.println("������ļ���·�������ڣ���������");
			} else if (dir.isFile()) {
				System.out.println("����������ļ�·�����������ļ���·��");
			} else {
				return dir;
			}
		}
	}

	public static void printJavaFile(File dir) {
		// 1,��ȡ���ļ��������ļ���
		File[] subFiles = dir.listFiles();
		// 2���������� �����.java�ʹ�ӡ
		for (File subFile : subFiles) {
			if (subFile.isFile() && subFile.getName().endsWith(".java")) {
				count++;
				System.out.println(subFile);
			} else {
				// ������ļ��� �͵ݹ����
				if (subFile.isDirectory()) {
					printJavaFile(subFile);
				}
			}
		}
	}
}
