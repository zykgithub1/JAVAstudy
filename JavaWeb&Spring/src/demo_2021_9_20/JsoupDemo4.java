package demo_2021_9_20;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupDemo4 {
    public static void main(String[] args) throws IOException {
        String path ="D:\\oldDownloads\\vsproject\\eclipseCode\\new Javacode\\" +
                "JavaWeb&Spring\\src\\demo_2021_9_20\\student.xml";
        Document document = Jsoup.parse(new File(path), "utf-8");
        Elements names = document.getElementsByTag("name");
        System.out.println(names.size());
        System.out.println("--------------------------------");
        Element element_student = document.getElementsByTag("student").get(0);
        Elements ele_name = element_student.getElementsByTag("name");
        System.out.println(ele_name.size());

        String number = element_student.attr("number");
        System.out.println(number);

        String text1 = ele_name.text();
        String html = ele_name.html();
        System.out.println(text1);
        System.out.println(html);


    }

}
