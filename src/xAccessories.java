import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class xAccessories {
    Scanner xRead = null;
    File xData = new File("iData/Accessories/xAccessories.csv");
    Map<String, String> xAccessories = new HashMap<>();
    Useful<String> xStack = new Useful<>();

    public xAccessories() {
        loadxAccessories();
        ay3Stack();
    }


    private void loadxAccessories() {

        try {
            xRead = new Scanner(xData);
        } catch (FileNotFoundException e) {
            System.out.println("No file found");
        }

        if (xRead == null) {
            return;
        }

        while (xRead.hasNextLine()) {
            String line = xRead.nextLine();
            String[] console = line.split(",");
            String abbrev = console[0];
            String cname = console[1];
            xAccessories.put(abbrev, cname);
        }
    }

    private void ay3Stack() {
        try {
            xRead = new Scanner(xData);
        } catch (FileNotFoundException e) {
            System.out.println("No File");
        }
        if (xRead == null) {
            return;
        }
        while (xRead.hasNextLine()) {
            String line = xRead.nextLine();
            if (line.length() > 0) {
                xStack.push(line);
            }
        }
    }
}
