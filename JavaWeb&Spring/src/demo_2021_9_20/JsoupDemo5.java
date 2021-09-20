package demo_2021_9_20;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupDemo5 {
    public static void main(String[] args) throws IOException {
        String path ="D:\\oldDownloads\\vsproject\\eclipseCode\\new Javacode\\" +
                "JavaWeb&Spring\\src\\demo_2021_9_20\\student.xml";
        Document document = Jsoup.parse(new File(path), "utf-8");
        Elements names = document.select("name");
        System.out.println(names);
        System.out.println("------------------------");

        Elements elements1 = document.select("#itcast");
        System.out.println(elements1);
        System.out.println("------------------------");
        //获取student子标签平且number属性为heima0001的age子标签
        System.out.println("|||||||||||||||||||||||||||\\>");
        Elements element2 = document.select("student[number='heima_0001']");
        System.out.println(element2);
        System.out.println("------------------------");
        System.out.println("|||||||||||||||||||||||||||\\>");
        Elements element3 = document.select("student[number='heima_0001']>age");
        System.out.println(element3);
        System.out.println("------------------------");
        System.out.println("age||||||||||||||||||||||||||\\>");
        Elements element4 = document.select("student[number='heima_0001']").select("age");
        System.out.println(element4);
        System.out.println("---last Age--------");


    }

}
