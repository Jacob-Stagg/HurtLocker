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

        Map<String, Integer> groceryList = new HashMap<String, Integer>();

        Pattern milk = Pattern.compile("milk", Pattern.CASE_INSENSITIVE);
        Pattern bread = Pattern.compile("bread", Pattern.CASE_INSENSITIVE);
        Pattern cookies = Pattern.compile("cookies", Pattern.CASE_INSENSITIVE);
        Pattern apples = Pattern.compile("apples", Pattern.CASE_INSENSITIVE);

        Matcher matchMilk = milk.matcher(result);
        Matcher matchBread = bread.matcher(result);
        Matcher matchCookies = cookies.matcher(result);
        Matcher matchApples = apples.matcher(result);

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
            System.out.println("Price: " + "0.00" + " \t\t seen: " + 0 + " times");
            System.out.println("-------------\t\t -------------");
            System.out.println();
        }

        return "";
    }

    public static void main(String[] args) throws Exception {
        String output = new Main().patternFinder(new Main().readRawDataToString());
        System.out.println(output);
    }
}