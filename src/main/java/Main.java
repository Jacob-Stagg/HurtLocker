import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.*;

public class Main {

    public String readRawDataToString() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public String patternFinder(String result) throws Exception {
        int milkCount = 0;
        int breadCount = 0;
        int cookieCount = 0;
        int appleCount = 0;
        Map<String, Integer> groceryList = new HashMap<String, Integer>();
        Pattern pattern1 = Pattern.compile("milk", Pattern.CASE_INSENSITIVE);
        Pattern pattern2 = Pattern.compile("bread", Pattern.CASE_INSENSITIVE);
        Pattern pattern3 = Pattern.compile("cookies", Pattern.CASE_INSENSITIVE);
        Pattern pattern4 = Pattern.compile("apples", Pattern.CASE_INSENSITIVE);
        Matcher matchP1 = pattern1.matcher(result);
        Matcher matchP2 = pattern2.matcher(result);
        Matcher matchP3 = pattern3.matcher(result);
        Matcher matchP4 = pattern4.matcher(result);

        while(matchP1.find()) {
            milkCount++;
        }

        while(matchP2.find()) {
            breadCount++;
        }

        while(matchP3.find()) {
            cookieCount++;
        }

        while(matchP4.find()) {
            appleCount++;
        }

        groceryList.put("milk", milkCount);
        groceryList.put("bread", breadCount);
        groceryList.put("cookies", cookieCount);
        groceryList.put("apples", appleCount);

        for (String key : groceryList.keySet()) {
            System.out.println("name: " + key + " \t\t seen: " + groceryList.get(key) + " times");
        }

        return null;
    }

    public static void main(String[] args) throws Exception {
        String output = new Main().patternFinder(new Main().readRawDataToString());
        System.out.println(output);
    }
}