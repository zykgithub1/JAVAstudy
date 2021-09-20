package demo_2021_9_20;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class JsoupDemo3 {
    public static void main(String[] args) throws IOException {
        String path ="D:\\oldDownloads\\vsproject\\eclipseCode\\new Javacode\\" +
                "JavaWeb&Spring\\src\\demo_2021_9_20\\student.xml";
        Document document = Jsoup.parse(new File(path), "utf-8");
        Elements students = document.getElementsByTag("student");
        System.out.println(students.get(0).text());
//        System.out.println(students.get(0).text());
        Element itcast = document.getElementById("itcast");
        System.out.println(itcast);
        System.out.println("--------------------------");
        Elements heima1 = document.getElementsByAttributeValue("number", "heima_0001");
        System.out.println(heima1);

    }

}
