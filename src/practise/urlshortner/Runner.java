package practise.urlshortner;

import java.util.Random;

public class Runner {
    public static void main(String[] args) {
        Random random = new Random();
        long id = random.nextLong();
        System.out.println(" Generated Suffix: " +UrlShortener.encode(id));
    }
}