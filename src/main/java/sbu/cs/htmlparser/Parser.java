package sbu.cs.htmlparser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Parser {
    public static List<Country> countries = new ArrayList<>();

    public static List<Country> sortByName() {
        List<Country> sortedByName = new ArrayList<>(countries);
        // Sort countries alphabetically (least)
        sortedByName.sort(Comparator.comparing(Country::getName));

        return sortedByName;
    }

    public static List<Country> sortByPopulation() {
        List<Country> sortedByPopulation = new ArrayList<>(countries);
        // Sort countries by population (most)
        sortedByPopulation.sort(Comparator.comparing(Country::getPopulation).reversed());

        return sortedByPopulation;
    }

    public static List<Country> sortByArea() {
        List<Country> sortedByArea = new ArrayList<>(countries);
        // Sort countries by area (most)
        sortedByArea.sort(Comparator.comparing(Country::getArea).reversed());

        return sortedByArea;
    }

    public static void setUp() throws IOException {

        //Parse the HTML file using Jsoup
        File input = new File("src/main/resources/Files/country-list.html");
        Document doc = Jsoup.parse(input, "UTF-8");

        // Extract data from the HTML
        Elements countryClass = doc.select("div.country");

        // Iterate through each country div to extract country data\
        for (Element country : countryClass) {
            String name = country.select(".country-name").first().ownText();
            String capital = country.select(".country-info").select("span.country-capital").first().ownText();
            int population = Integer.parseInt(country.select(".country-info").select("span.country-population").first().ownText());
            double area = Double.parseDouble(country.select(".country-info").select("span.country-area").first().ownText());

            countries.add(new Country(name, capital, population, area));
        }
    }


}

