package demo_2021_9_20;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class JsoupDemo1 {
    public static void main(String[] args) throws IOException {
        String path ="D:\\oldDownloads\\vsproject\\eclipseCode\\new Javacode\\" +
                "JavaWeb&Spring\\src\\demo_2021_9_20\\student.xml";
        Document document = Jsoup.parse(new File(path), "utf-8");
        Elements elements = document.getElementsByTag("name");
        System.out.println(elements.size());
        Element ele=elements.get(0);
        System.out.println(ele.text());
    }
}
