import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;//�������
import javafx.scene.control.ScrollPane;
public class App15_7 extends Application
{
  private TextField tf=new TextField();
  private PasswordField pf=new PasswordField();
  private TextArea ta=new TextArea("�������û���������");
  @Override
  public void start(Stage Stage)
  {
    GridPane rootGP=new GridPane();
    final Label lab1=new Label("�û�����");
    final Label lab2=new Label("��  �룺");
    tf.setPromptText("�����û���");
    pf.setPromptText("��������");
    rootGP.add(lab1,0,0);
    rootGP.add(tf,1,0);
    rootGP.add(lab2,0,1);
    rootGP.add(pf,1,1);
    final ScrollPane scro=new ScrollPane();
    ta.setPrefColumnCount(15);
    ta.setEditable(false);
    pf.setOnAction(e->
      {
        if(tf.getText().equals("tim") && pf.getText().equals("123") || tf.getText().equals("bill") && pf.getText().equals("321") || tf.getText().equals("Mary") && pf.getText().equals("121") || tf.getText().equals("carl") && pf.getText().equals("110"))
        {
          ta.setEditable(true);
          ta.setWrapText(true);
          ta.setStyle("-fx-text-fill:red");
          ta.setText("�û�����������ȷ����¼�ɹ�");
        }
        else {
        	ta.setText("�û�����������󣬵�¼ʧ��");
        }
      }
    );
    rootGP.add(scro,0,3,4,3);
    Scene scene=new Scene(rootGP,190,120);
    Stage.setTitle("�ı��ؼ�Ӧ��");
    Stage.setScene(scene);
    Stage.show();
  }
  
  public static void main(String[] args) {
	  launch(args);
  }
}