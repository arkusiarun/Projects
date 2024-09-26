package practise.urlshortner;

public class UrlShortener {
    public static final String DATA_SET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public static final int BASE = 62;

    public static String encode(long id) {
        StringBuilder sb = new StringBuilder();
        while(id>0) {
            sb.append(DATA_SET.charAt((int) (id%BASE)));
            id = id/BASE;
        }
        return sb.toString();
    }
}
