import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VideoGames {
    // Video games need to be sorted by their publishers
    // They are also sorted by greatest to the least available3
    Scanner read = null;
    Map<String, String> games = new HashMap<>();
    Map<String, String> games1 = new HashMap<>();
    Map<String, String> games2 = new HashMap<>();
    Map<String, String> games3 = new HashMap<>();
    Useful<String> gameStack = new Useful<>();
    File ps3 = new File("iData/PlaystationGames/ps3Games.csv");
    File ps4 = new File("iData/PlaystationGames/ps4Games.csv");
    File ps5 = new File("iData/PlaystationGames/ps5Games.csv");
    File psVita = new File("iData/PlaystationGames/psvitaGames.csv");

    public VideoGames() {

        loadps3Games();
        loadps4Games();
        loadps5Games();
        loadpsvitaGames();
        ps3Stack();
        ps4Stack();
        ps5Stack();
        psvitaStack();
    }

    public void loadps3Games() {
        try {
            read = new Scanner(ps3);
        } catch (FileNotFoundException e) {
            System.out.println("No file found");
        }

        if (read == null) {
            return;
        }

        while (read.hasNextLine()) {
            String line = read.nextLine();
            String[] console = line.split(",");
            String abbrev = console[0];
            String cname = console[1];
            games.put(abbrev, cname);
        }
    }

    public void loadps4Games() {
        try {
            read = new Scanner(ps4);
        } catch (FileNotFoundException e) {
            System.out.println("No file found");
        }

        if (read == null) {
            return;
        }

        while (read.hasNextLine()) {
            String line = read.nextLine();
            String[] console = line.split(",");
            String abbrev = console[0];
            String cname = console[1];
            games1.put(abbrev, cname);
        }
    }

    public void loadps5Games() {
        try {
            read = new Scanner(ps5);
        } catch (FileNotFoundException e) {
            System.out.println("No file found");
        }

        if (read == null) {
            return;
        }

        while (read.hasNextLine()) {
            String line = read.nextLine();
            String[] console = line.split(",");
            String abbrev = console[0];
            String cname = console[1];
            games2.put(abbrev, cname);
        }
    }

    public void loadpsvitaGames() {

        try {
            read = new Scanner(psVita);
        } catch (FileNotFoundException e) {
            System.out.println("No file found");
        }

        if (read == null) {
            return;
        }

        while (read.hasNextLine()) {
            String line = read.nextLine();
            String[] console = line.split(",");
            String abbrev = console[0];
            String cname = console[1];
            games3.put(abbrev, cname);
        }
    }

    public void ps3Stack() {
        try {
            read = new Scanner(ps3);
        } catch (FileNotFoundException e) {
            System.out.println("File was not found!");
        }
        if (read == null) {
            return;
        }
        while (read.hasNextLine()) {
            String line = read.nextLine();
            if (line.length() > 0) {
                gameStack.push(line);
            }
        }
    }

    private void ps4Stack() {
        try {
            read = new Scanner(ps4);
        } catch (FileNotFoundException e) {
            System.out.println("File was not found!");
        }
        if (read == null) {
            return;
        }
        while (read.hasNextLine()) {
            String line = read.nextLine();
            if (line.length() > 0) {
                gameStack.push(line);
            }
        }
    }

    private void ps5Stack() {
        try {
            read = new Scanner(ps5);
        } catch (FileNotFoundException e) {
            System.out.println("File was not found!");
        }
        if (read == null) {
            return;
        }
        while (read.hasNextLine()) {
            String line = read.nextLine();
            if (line.length() > 0) {
                gameStack.push(line);
            }
        }
    }

    private void psvitaStack() {
        try {
            read = new Scanner(psVita);
        } catch (FileNotFoundException e) {
            System.out.println("File was not found!");
        }
        if (read == null) {
            return;
        }
        while (read.hasNextLine()) {
            String line = read.nextLine();
            if (line.length() > 0) {
                gameStack.push(line);
            }
        }
    }
}





