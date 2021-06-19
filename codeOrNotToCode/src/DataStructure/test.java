package DataStructure;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class test {
	public static void main(String[] args) {
		List<String> arr=new ArrayList();
		Set<Character>set=new HashSet();
		String path="zyk";
		path+="abc";
		System.out.println(path);
		path=path.substring(1,4);
		System.out.println(path);
	}

}
