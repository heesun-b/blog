package shop.mtcoding.blog.util;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

public class HtmlParseTest {

    @Test
    public void jsoup_test2() {
        String html = "<p>1</p><p><img src=\"data:image/png;base64,iVBORw0KG\"></p>";
        Document doc = Jsoup.parse(html);
        System.out.println("doc:" + doc);
        Element el = doc.select("img").first();
        String s = el.attr("src");
        if (s == null) {
            // 임시 사진 제공
            // db 썸네일에 static 이미지 폴더에 있는 사진 넣기
            System.out.println(html);
        } else {

            System.out.println("있을 때 :" + s);

            // db 썸네일에 뽑아낸 img 넣기
        }
    }

    @Test
    public void jsoup_test1() throws Exception {
        System.out.println("==============================");
        Document doc = Jsoup.connect("https://en.wikipedia.org/").get();
        // System.out.println(doc);
        System.out.println(doc.title());
        Elements newsHeadlines = doc.select("#mp-itn b a");
        System.out.println("==============================");

        // for (Element headline : newsHeadlines) {
        // log("%s\n\t%s",
        // headline.attr("title"), headline.absUrl("href"));
        // }
    }

    @Test
    public void parse_test1() {
        String html = "<p>1</p><p><img src=\"data:image/png;base64,iVBORw0KG\"></p>";
        String tag = parseEL(html, "img");
        System.out.println(tag);
        String attr = parseAttr(tag, "src");
        System.out.println(attr);
    }

    private String parseEL(String html, String tag) {
        String s1 = html.substring(html.indexOf(tag) - 1);
        return s1.substring(0, s1.indexOf(">") + 1);
    }

    private String parseAttr(String el, String attr) {
        String s1 = el.substring(el.indexOf(attr));

        int begin = s1.indexOf("\"");
        int end = s1.lastIndexOf("\"");

        return s1.substring(begin + 1, end);
    }

}
