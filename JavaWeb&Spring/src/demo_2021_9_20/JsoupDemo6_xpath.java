package demo_2021_9_20;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsoupDemo6_xpath {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        String path ="D:\\oldDownloads\\vsproject\\eclipseCode\\new Javacode\\" +
                "JavaWeb&Spring\\src\\demo_2021_9_20\\student.xml";
        Document document = Jsoup.parse(new File(path), "utf-8");
        //creat JXDocument obj
        JXDocument jxDocument=new JXDocument(document);
        List<JXNode> students = jxDocument.selN("//student");
        for(JXNode stu:students){
            System.out.println(stu);
        }
        System.out.println("----------------------------------!!!!");
        List<JXNode> student_names = jxDocument.selN("//student///name");
        for(JXNode stu:student_names){
            System.out.println(stu);
        }
        System.out.println("------------------last----------------!!!!");
        List<JXNode> student3 = jxDocument.selN("//student/name[@id='itcast']");
        for(JXNode stu:student3){
            System.out.println(stu);
        }
        System.out.println("---------------------last-------------!!!!");
    }
}
