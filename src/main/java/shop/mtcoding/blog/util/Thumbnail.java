package shop.mtcoding.blog.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Thumbnail {

    public static String thumbnailParse(String html) {
        Document d = Jsoup.parse(html);
        Elements els = d.select("img");

        if (els.size() == 0) {
            return "/images/dora.png";
        } else {
            Element el = els.get(0);
            return el.attr("src");
        }
    }
}
