import java.awt.Button;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileReader;
import java.io.IOException;
public class App15_3 extends Frame {

//定义在外面
	static TextArea ta;
	TextField tf;
	
	public App15_3() {//用构造函数初始化
		ta = new TextArea("");
		ta.setBounds(50, 50, 500, 200);
		tf = new TextField("");
		tf.setBounds(50, 300, 400, 30);
		Button b1 = new Button("发送");
		b1.setBounds(450, 300, 30, 30);
		Button b2 = new Button("关闭");
		b2.setBounds(500, 300, 30, 30);
		add(ta);
		add(tf);
		add(b1);
		add(b2);

		b1.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub
	ta.append(tf.getText()+"\n");
	tf.setText("");
	}
});
	jie er = new jie();
	b2.addActionListener(er);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent ee) {
				System.exit(0);
				}
			});
		}
public static void main(String[] args) throws IOException{
//	Frame f = new Frame("QQ");
	FileReader fr=new FileReader("myfilee.txt");
	char[] c=new char[1000];
	int len;
	while((len=fr.read(c))!=-1){
		String str = new String(c,0,len);
		System.out.println(str);
	}

	App15_3 f = new App15_3();
	f.setLayout(null);
	f.setTitle("聊天窗口");
	f.setSize(600, 400);
	f.setVisible(true);
	}
class jie implements ActionListener {
public void actionPerformed(ActionEvent e) {
	System.exit(0);//不是1
	}
  }
}