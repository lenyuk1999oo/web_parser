import model.Think;
import model.Thinks;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import serialize.JsonSerialize;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://www.aboutyou.de/c/maenner/bekleidung-20290").get();

            JsonSerialize.serialize(
                    new Thinks().setThinks(
                            parseThinks(doc.select(".ReactVirtualized__Grid__innerScrollContainer"))),
                    "thinks.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Think> parseThinks(Elements document) {
        ArrayList<Think> thinks = new ArrayList<>();

        for (Element element : document.select(".sc-1qheze-0.dgBQdu")) {
            thinks.add(parseOneThink(element));
        }

        return thinks;
    }

    public static Think parseOneThink(Element element) {
        return new Think()
                .setArticleID(element.select("a").attr("id"))
                .setProductName(element.select("img").attr("alt").replace(", Produktansicht", ""))
                .setBrand(element.select(".sc-1gv4rhx-2").text())
                .setPrice(element.select(".sc-1kqkfaq-0").first().text())
                .setColors(parseColors(element.select(".sc-1gv4rhx-4")))
                .setSizes(parseSizes(element.select(".sc-1gv4rhx-6")))
                .setImgURL(element.select("img").attr("src"));
    }

    public static ArrayList<String> parseColors(Elements element) {
        ArrayList<String> colors = new ArrayList<>();

        for (Element element1 : element.select(".sc-1erb38y-0")) {
            colors.add(element1.attr("color"));
        }

        return colors;
    }

    public static ArrayList<String> parseSizes(Elements element) {
        ArrayList<String> sizes = new ArrayList<>();

        if (element.text().split(":").length > 1)
            sizes.addAll(Arrays.asList(element.text().split(":")[1].split(", ")));
        else {
            sizes.add("all");
        }

        return sizes;
    }
}
