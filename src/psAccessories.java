import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class psAccessories {
    Scanner readPs = null;
    File psData = new File("IData/Accessories/psAccessories.csv");
    Map<String, String> psAccessories = new HashMap<>();
    Useful<String> psStack = new Useful<>();

    public psAccessories() {
        loadpsAccessories();
        ay2Stack();
    }


    private void loadpsAccessories() {
        try {
            readPs = new Scanner(psData);
        } catch (FileNotFoundException e) {
            System.out.println("No file found");
        }
        if (readPs == null) {
            return;
        }
        while (readPs.hasNextLine()) {
            String line = readPs.nextLine();
            String[] console = line.split(",");
            String abbrev = console[0];
            String cname = console[1];
            psAccessories.put(abbrev, cname);
        }
    }

    private void ay2Stack() {
        try {
            readPs = new Scanner(psData);
        } catch (FileNotFoundException e) {
            System.out.println("No file exists");
        }
        if (readPs == null) {
            return;
        }
        while (readPs.hasNextLine()) {
            String l = readPs.nextLine();
            if (l.length() > 0) {
                psStack.push(l);
            }
        }


    }
}

