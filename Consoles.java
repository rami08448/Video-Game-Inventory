import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Consoles {
    String content = "";
    Scanner reader = null;
    File consoleData = new File("iData/Consoles/consoleInventory.csv");
    File consoleData1 = new File("iData/Consoles/consolePrices.csv");
    Map<String, String> sConsoles = new HashMap<>();
    Map<String, String> pConsoles = new HashMap<>();
    Map<String, String> allconsoles = new HashMap<>();
    Map<String, String> allconsoles1 = new HashMap<>();
    Useful<String> stack = new Useful<>();


    public Consoles() {
        loadconsoleInventory();
        loadconsolePrices();
        pricesStack();
        inventoryStack();

    }

    // We might not need enumeration, but instead hashmaps and csv files and sorts for the consoles.
    private void loadconsoleInventory() {
        try {
            reader = new Scanner(consoleData);
        } catch (FileNotFoundException e) {
            System.out.println("No files found");
        }

        if (reader == null) {
            return;
        }

        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] console = line.split(",");
            String abbrev = console[0];
            String cname = console[1];
            String uem = console[2];
            sConsoles.put(abbrev, uem);
            allconsoles.put(abbrev, cname);
        }
    }

    private void loadconsolePrices() {

        try {
            reader = new Scanner(consoleData1);
        } catch (FileNotFoundException e) {
            System.out.println("No file found");
        }

        if (reader == null) {
            return;
        }

        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] console = line.split(",");
            String abbrev = console[0];
            String cname = console[1];
            String uem = console[2];
            pConsoles.put(abbrev, uem);
            allconsoles1.put(abbrev, cname);
        }
    }


    private void pricesStack() {
        try {
            reader = new Scanner(consoleData1);
        } catch (FileNotFoundException e) {
            System.out.println("No file found");
        }

        if (reader == null) {
            return;
        }

        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            if (line.length() > 0)
                stack.push(line);
        }
       /* while (stack.peek() != null) {

            System.out.println(stack.pop());
        }

        */

    }

    private void inventoryStack() {
        try {
            reader = new Scanner(consoleData1);
        } catch (FileNotFoundException e) {
            System.out.println("No file found");
        }

        if (reader == null) {
            return;
        }

        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            if (line.length() > 0)
                stack.push(line);
        }
      /* while (stack.peek() != null) {

            System.out.println(stack.pop(input));
        }

       */


    }
}

















