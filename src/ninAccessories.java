import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ninAccessories {
    Scanner readNin = null;
    File nintendo = new File("iData/Accessories/ninAccessories.csv");
    Map<String, String> ninAccessories = new HashMap<>();
    Useful<String> ninStack = new Useful<>();

    public ninAccessories() {
        loadninAccessories();
        ay1Stack();
    }


    public void loadninAccessories() {

        try {
            readNin = new Scanner(nintendo);
        } catch (FileNotFoundException e) {
            System.out.println("No file found");
        }

        if (readNin == null) {
            return;
        }

        while (readNin.hasNextLine()) {
            String line = readNin.nextLine();
            String[] console = line.split(",");
            String abbrev = console[0];
            String cname = console[1];
            ninAccessories.put(abbrev, cname);
        }
    }

    private void ay1Stack() {
        try {
            readNin = new Scanner(nintendo);
        } catch (FileNotFoundException e) {
            System.out.println("File was not found!");
        }
        if (readNin == null) {
            return;
        }
        while (readNin.hasNextLine()) {
            String line = readNin.nextLine();
            if (line.length() > 0) {
                ninStack.push(line);
            }
        }


    }
}
