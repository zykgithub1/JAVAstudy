import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;//网格面板
import javafx.scene.control.ScrollPane;
public class App15_7 extends Application
{
  private TextField tf=new TextField();
  private PasswordField pf=new PasswordField();
  private TextArea ta=new TextArea("请输入用户名和密码");
  @Override
  public void start(Stage Stage)
  {
    GridPane rootGP=new GridPane();
    final Label lab1=new Label("用户名：");
    final Label lab2=new Label("密  码：");
    tf.setPromptText("输入用户名");
    pf.setPromptText("输入密码");
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
          ta.setText("用户名和密码正确，登录成功");
        }
        else {
        	ta.setText("用户名或密码错误，登录失败");
        }
      }
    );
    rootGP.add(scro,0,3,4,3);
    Scene scene=new Scene(rootGP,190,120);
    Stage.setTitle("文本控件应用");
    Stage.setScene(scene);
    Stage.show();
  }
  
  public static void main(String[] args) {
	  launch(args);
  }
}