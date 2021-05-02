package otherIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class objectIpS {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream("f.txt"));
		Person p1=(Person)ois.readObject();
		Person p2=(Person)ois.readObject();
		System.out.println(p1);
		System.out.println(p2);
		ois.close();
	}

}
