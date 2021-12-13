import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.regex.*;

public class Main {

    public String readRawDataToString() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public String patternFinder(String result) throws Exception {
        String grocerylist = "complete";
        int counter = 0;
        Pattern pattern = Pattern.compile("milk", Pattern.CASE_INSENSITIVE);
        Matcher match = pattern.matcher(result);

        while(match.find()) {
            counter++;
            System.out.println("Match no:" + counter);
            System.out.println("Found at: " + match.start() + " - " + match.end());
        }

        return grocerylist;
    }

    public static void main(String[] args) throws Exception {
        String output = new Main().patternFinder(new Main().readRawDataToString());
        System.out.println(output);
    }
}