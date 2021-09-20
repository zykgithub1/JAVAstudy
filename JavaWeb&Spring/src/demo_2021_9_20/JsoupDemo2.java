package demo_2021_9_20;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class JsoupDemo2 {
    public static void main(String[] args) throws IOException {
        String path ="D:\\oldDownloads\\vsproject\\eclipseCode\\new Javacode\\" +
                "JavaWeb&Spring\\src\\demo_2021_9_20\\student.xml";
        System.out.println(path);
//        Document document = Jsoup.parse(new File(path), "utf-8");
//        System.out.println(document);
        String str="<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "<students>\n" +
                "\t<student number=\"heima_0001\">\n" +
                "\t\t<name>曾驿凯</name>\n" +
                "\t\t<age>24</age>\n" +
                "\t\t<sex>male</sex>\n" +
                "\t</student>\n" +
                "\t<student number=\"heima_0002\">\n" +
                "\t\t<name>lisi</name>\n" +
                "\t\t<age>24</age>\n" +
                "\t\t<sex>female</sex>\n" +
                "\t</student>\n" +
                "\n" +
                " </students>";
//        Document document1 = Jsoup.parse(str);
//        System.out.println(document1);
        URL url=new URL("http://www.youdao.com/w/eng/instance/#keyfrom=dict2.index");
        Document document = Jsoup.parse(url, 3000);
        System.out.println(document);

    }

}
