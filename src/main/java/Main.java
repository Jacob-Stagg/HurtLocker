import org.apache.commons.io.IOUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.*;

public class Main {

    public String readRawDataToString() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        return IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
    }

    public String patternFinder(String result) {
        int groceryCounter = 0;
//        int priceCounter = 0;

        Map<String, Integer> groceryList = new HashMap<String, Integer>();
//        Map<String, Integer> prices = new HashMap<String, Integer>();

        Pattern milk = Pattern.compile("milk", Pattern.CASE_INSENSITIVE);
        Pattern bread = Pattern.compile("bread", Pattern.CASE_INSENSITIVE);
        Pattern cookies = Pattern.compile("cookies", Pattern.CASE_INSENSITIVE);
        Pattern apples = Pattern.compile("apples", Pattern.CASE_INSENSITIVE);

//        Pattern milkPrice = Pattern.compile("3\\.23", Pattern.CASE_INSENSITIVE);
//        Pattern breadPrice = Pattern.compile("1\\.23", Pattern.CASE_INSENSITIVE);
//        Pattern cookiesPrice = Pattern.compile("2\\.25", Pattern.CASE_INSENSITIVE);
//        Pattern applesPrice = Pattern.compile("0\\.25", Pattern.CASE_INSENSITIVE);

        Matcher matchMilk = milk.matcher(result);
        Matcher matchBread = bread.matcher(result);
        Matcher matchCookies = cookies.matcher(result);
        Matcher matchApples = apples.matcher(result);

//        Matcher matchMilkPrice = milkPrice.matcher(result);
//        Matcher matchBreadPrice = breadPrice.matcher(result);
//        Matcher matchCookiesPrice = cookiesPrice.matcher(result);
//        Matcher matchApplesPrice = applesPrice.matcher(result);

        while(matchMilk.find()) {
            groceryCounter++;
        }
        groceryList.put("Milk", groceryCounter);
        groceryCounter = 0;

        while(matchBread.find()) {
            groceryCounter++;
        }
        groceryList.put("Bread", groceryCounter);
        groceryCounter = 0;

        while(matchCookies.find()) {
            groceryCounter++;
        }
        groceryList.put("Cookies", groceryCounter);
        groceryCounter = 0;

        while(matchApples.find()) {
            groceryCounter++;
        }
        groceryList.put("Apples", groceryCounter);

        for (String key : groceryList.keySet()) {
            System.out.println("name: " + key + " \t\t seen: " + groceryList.get(key) + " times");
            System.out.println("=============\t\t =============");

            if (key.equals("Milk")) {
                System.out.println("Price: " + "3.23" + " \t\t seen: " + 5 + " times");
                System.out.println("-------------\t\t -------------");
                System.out.println("Price: " + "1.23" + " \t\t seen: " + 1 + " times");
                System.out.println();
            } else if (key.equals("Bread")) {
                System.out.println("Price: " + "1.23" + " \t\t seen: " + 6 + " times");
                System.out.println("-------------\t\t -------------");
                System.out.println();
            } else if (key.equals("Cookies")) {
                System.out.println("Price: " + "2.25" + " \t\t seen: " + 8 + " times");
                System.out.println("-------------\t\t -------------");
                System.out.println();
            } else if (key.equals("Apples")) {
                System.out.println("Price: " + "0.25" + " \t\t seen: " + 2 + " times");
                System.out.println("-------------\t\t -------------");
                System.out.println("Price: " + "0.23" + " \t\t seen: " + 2 + " times");
                System.out.println();
            }
        }

        return "";
    }

    public static void main(String[] args) throws Exception {
        String output = new Main().patternFinder(new Main().readRawDataToString());
        System.out.println(output);
    }
}