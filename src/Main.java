import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Main extends JFrame implements ActionListener {
    Scanner reader = null;
    String input;
    int buy;
    private JTextArea mArea;
    private JTextField mText;
    private JButton mPrice;
    private JButton mBuy;
    private JButton mSell;
    private JButton mTrade;
    private JButton mSearch;
    private JButton mRemove;


    public Main() {
        openGui();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }

    public void openGui() {
        //minimum GUI requirement
        setTitle("VIDEO-GO");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Text Area and Text field
        mText = new JTextField(12);
        mText.addActionListener(this);

        mArea = new JTextArea(30, 40);

        //ScrollPane
        JScrollPane pane = new JScrollPane(mArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        //JLabel for "TextField"
        JLabel search = new JLabel();
        search.setFont(new Font("Search", Font.ITALIC, 17));
        search.setText("Search Here: ");
        search.setForeground(Color.green);

        //JButton for "Search Option"
        mSearch = new JButton("Search");
        mSearch.setBackground(Color.PINK);
        mSearch.addActionListener(this);

        //JButton for "Check Price Option"
        mPrice = new JButton("Check Price");
        mPrice.setBackground(Color.ORANGE);
        mPrice.addActionListener(this);


        JPanel panel = new JPanel();

        JPanel panel1 = new JPanel();


        mBuy = new JButton("Buy");
        mBuy.setBackground(Color.cyan);
        mBuy.addActionListener(this);

        mSell = new JButton("Sell");
        mSell.setBackground(Color.green);
        mSell.addActionListener(this);

        mTrade = new JButton("Trade");
        mTrade.setBackground(Color.YELLOW);
        mTrade.addActionListener(this);

        mRemove = new JButton("Remove");
        mRemove.setBackground(Color.RED);
        mRemove.addActionListener(this);

        JPanel buttons = new JPanel();
        buttons.add(mBuy);
        buttons.add(mSell);
        buttons.add(mTrade);
        buttons.add(mRemove);


        //create a Menu Bar
        JMenuBar bar = new JMenuBar();
        //Adding Menus to the menu
        JMenu consoles = new JMenu("Consoles");
        JMenu games = new JMenu("Video-Games");
        JMenu accessories = new JMenu("Accessories");
        bar.add(consoles);
        bar.add(games);
        bar.add(accessories);
        //submenu PS
        JMenu ps = new JMenu("Playstation");
        consoles.add(ps);
        JMenuItem ps3 = new JMenuItem("PS3");
        ps3.addActionListener(this);
        ps.add(ps3);
        JMenuItem ps4 = new JMenuItem("PS4/PS5");
        ps4.addActionListener(this);
        ps.add(ps4);
        JMenuItem psv = new JMenuItem("PS-VITA");
        psv.addActionListener(this);
        ps.add(psv);
        JMenuItem psvr = new JMenuItem("PS-VR");
        psvr.addActionListener(this);
        ps.add(psvr);
        //submenu XB
        JMenu xb = new JMenu("Xbox");
        consoles.add(xb);
        JMenuItem x360 = new JMenuItem("Xbox 360");
        x360.addActionListener(this);
        xb.add(x360);
        JMenuItem xe = new JMenuItem("Xbox One");
        xe.addActionListener(this);
        xb.add(xe);
        JMenuItem xs = new JMenuItem("Xbox Series X/S");
        xs.addActionListener(this);
        xb.add(xs);
        //submenu ND
        JMenu nin = new JMenu("Nintendo");
        consoles.add(nin);
        JMenuItem wii = new JMenuItem("Wii/WiiU");
        wii.addActionListener(this);
        nin.add(wii);
        JMenuItem ds = new JMenuItem("3DS/2DS");
        ds.addActionListener(this);
        nin.add(ds);
        JMenuItem sw = new JMenuItem("Switch");
        sw.addActionListener(this);
        nin.add(sw);
        //Menu Items for Video-Games
        //PS
        JMenu play = new JMenu("Playstation");
        JMenuItem g0 = new JMenuItem("PS3");
        g0.addActionListener(this);
        play.add(g0);
        JMenuItem g1 = new JMenuItem("PS4/PS5");
        g1.addActionListener(this);
        play.add(g1);
        JMenuItem g2 = new JMenuItem("PS-VITA");
        g2.addActionListener(this);
        play.add(g2);
        JMenuItem g3 = new JMenuItem("PS-VR");
        g3.addActionListener(this);
        play.add(g3);
        //Xbox
        JMenu xo = new JMenu("Xbox");
        JMenuItem g4 = new JMenuItem("Xbox 360");
        g4.addActionListener(this);
        xo.add(g4);
        JMenuItem g5 = new JMenuItem("Xbox One");
        g5.addActionListener(this);
        xo.add(g5);
        JMenuItem g6 = new JMenuItem("Xbox Series X/S");
        g6.addActionListener(this);
        xo.add(g6);
        //Nintendo
        JMenu nd = new JMenu("Nintendo");
        JMenuItem g7 = new JMenuItem("Wii/WiiU");
        g7.addActionListener(this);
        nd.add(g7);
        JMenuItem g8 = new JMenuItem("3DS/2DS");
        g8.addActionListener(this);
        nd.add(g8);
        JMenuItem g9 = new JMenuItem("Switch");
        g9.addActionListener(this);
        nd.add(g9);
        //Adding Jmenu to Jmenu
        games.add(play);
        games.add(xo);
        games.add(nd);
        //Menu Items for Accessories
        //PS
        JMenu pn = new JMenu("Playstation");
        JMenuItem c = new JMenuItem("Controllers");
        c.addActionListener(this);
        pn.add(c);
        JMenuItem d = new JMenuItem("Headsets");
        d.addActionListener(this);
        pn.add(d);
        JMenuItem e = new JMenuItem("Memory");
        e.addActionListener(this);
        pn.add(e);
        JMenuItem f = new JMenuItem("Protection");
        f.addActionListener(this);
        pn.add(f);
        //Xbox
        JMenu xx = new JMenu("Xbox");
        JMenuItem g = new JMenuItem("Controllers");
        g.addActionListener(this);
        xx.add(g);
        JMenuItem h = new JMenuItem("Headsets");
        h.addActionListener(this);
        xx.add(h);
        JMenuItem i = new JMenuItem("Memory");
        i.addActionListener(this);
        xx.add(i);
        JMenuItem j = new JMenuItem("Protection");
        j.addActionListener(this);
        xx.add(j);
        //Nintendo
        JMenu no = new JMenu("Nintendo");
        JMenuItem k = new JMenuItem("Controllers");
        k.addActionListener(this);
        no.add(k);
        JMenuItem l = new JMenuItem("Headsets");
        l.addActionListener(this);
        no.add(l);
        JMenuItem m = new JMenuItem("Memory");
        m.addActionListener(this);
        no.add(m);
        JMenuItem n = new JMenuItem("Protection");
        n.addActionListener(this);
        no.add(n);
        accessories.add(pn);
        accessories.add(xx);
        accessories.add(no);


        //adding items to Frame
        add(BorderLayout.NORTH, panel);
        panel.add(search);
        panel.add(mText);
        panel.add(mSearch);
        panel.add(mPrice);

        //Adding text area to Frame
        add(BorderLayout.CENTER, panel1);

        //add JScrollPane
        panel1.add(pane);

        //Adding buttons to frame
        add(BorderLayout.SOUTH, buttons);

        //make it show up on the screen
        setJMenuBar(bar);
        setVisible(true);
        setLocationRelativeTo(null);
        pack();


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object object = e.getSource();
        Consoles map = new Consoles();
        VideoGames map1 = new VideoGames();
        psAccessories map2 = new psAccessories();
        ninAccessories map3 = new ninAccessories();
        xAccessories map4 = new xAccessories();

        if (object instanceof JButton) {
            input = mText.getText().toUpperCase();

            if (object == mSearch) {
                if (map.sConsoles.containsKey(input)) {
                    mArea.setText("There are " + map.sConsoles.get(input) + " - " + map.allconsoles.get(input) + " - " + " consoles available.");
                } else if (map1.games.containsKey(input)) {
                    mArea.setText(map1.games.get(input) + " for - Playstation3 - is available.");
                } else if (map1.games1.containsKey(input)) {
                    mArea.setText(map1.games1.get(input) + " for - Playstation4 - is available.");
                } else if (map1.games2.containsKey(input)) {
                    mArea.setText(map1.games2.get(input) + " for - Playstation5 - is available.");
                } else if (map1.games3.containsKey(input)) {
                    mArea.setText(map1.games3.get(input) + " for - PlaystationVITA - is available.");
                } else if (map2.psAccessories.containsKey(input)) {
                    mArea.setText("There are " + map2.psAccessories.get(input) + "s" + " available.");
                } else if (map3.ninAccessories.containsKey(input)) {
                    mArea.setText("There are " + map3.ninAccessories.get(input) + "s" + " available.");
                } else if (map4.xAccessories.containsKey(input)) {
                    mArea.setText("There are " + map4.xAccessories.get(input) + "s" + " available.");
                } else {
                    JOptionPane.showMessageDialog(null, "Please use an abbreviation, or that item does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else if (object == mPrice) {
                if (map.pConsoles.containsKey(input)) {
                    mArea.setText("The " + map.allconsoles1.get(input) + " costs: " + "$" + map.pConsoles.get(input) + ".");
                } else {
                    JOptionPane.showMessageDialog(null, "No price available for that system!", "Price Unavailable", JOptionPane.WARNING_MESSAGE);
                }

            } else if (object == mBuy) {
                if (map.pConsoles.containsKey(input)) {
                    buy = JOptionPane.showConfirmDialog(null, "Do you want to buy the " + map.allconsoles1.get(input) + "?", "Buy", JOptionPane.YES_NO_OPTION);
                } else if (!map.pConsoles.containsKey(input)) {
                    JOptionPane.showMessageDialog(null, "Item is unavailable for purchase", "No-Item", JOptionPane.ERROR_MESSAGE);
                }
                if (buy == 0 && map.pConsoles.containsKey(input)) {
                    JOptionPane.showInputDialog(null, "Please Pay", JOptionPane.INFORMATION_MESSAGE);
                    int t = JOptionPane.showConfirmDialog(null, "Did you pay in full?", "Don't lie", JOptionPane.YES_NO_OPTION);
                    if (t == 0) {
                        System.out.println(map.stack.pop());
                        JSONObject json = new JSONObject();
                        try {
                            reader = new Scanner(map.consoleData);
                            while (reader.hasNextLine()) {
                                map.content = map.content.concat(reader.nextLine() + "\n");
                                FileWriter file = new FileWriter("iData/purchasedSystems.txt");
                                json.put(input, map.pConsoles.get(input));
                                json.write(file);
                                file.close();
                            }
                        } catch (JSONException | IOException ex) {
                            ex.printStackTrace();
                        }
                        //System.out.println(json);
                        JOptionPane.showMessageDialog(null, "Here is your new System!");
                    }
                    while (t == 1) {
                        JOptionPane.showInputDialog(null, "Please Pay", JOptionPane.INFORMATION_MESSAGE);
                        t = JOptionPane.showConfirmDialog(null, "Did you pay in full?", "Don't lie", JOptionPane.YES_NO_OPTION);
                        if (t == 0) {
                            System.out.println(map.stack.pop());
                            JSONObject json = new JSONObject();
                            try {
                                reader = new Scanner(map.consoleData);
                                while (reader.hasNextLine()) {
                                    map.content = map.content.concat(reader.nextLine() + "\n");
                                    FileWriter file = new FileWriter("res/purchasedSystems.json");
                                    json.put(input, map.pConsoles.get(input));
                                    json.write(file);
                                    file.close();
                                }
                            } catch (JSONException | IOException ex) {
                                ex.printStackTrace();
                            }
                            //System.out.println(json);
                            JOptionPane.showMessageDialog(null, "Here is your new System!");

                        }
                    }
                } else if (buy == 1) {
                    JOptionPane.showMessageDialog(null, "Enjoy Browsing!");
                }

            } else if (object == mSell) {
                buy = JOptionPane.showConfirmDialog(null, "Are selling an item today?", "Sell", JOptionPane.YES_NO_OPTION);
                if (buy == 0) {
                    JOptionPane.showInputDialog(null, "Please enter the item you plan to sell:");
                } else {
                    JOptionPane.showMessageDialog(null, "Enjoy Browsing!");
                }
            } else if (object == mTrade) {
                JOptionPane.showInputDialog(null, "What would you like to trade-in?", "Trade", JOptionPane.QUESTION_MESSAGE);
            } else if (object == mRemove) {
                int click = JOptionPane.showConfirmDialog(null, "Do you really want to remove an item?", "Trade", JOptionPane.YES_NO_OPTION);
                if (click == 0) {
                    JOptionPane.showInputDialog(null, "What would you like to remove?", "Remove", JOptionPane.QUESTION_MESSAGE);
                    JOptionPane.showInternalMessageDialog(null, "Loading");
                    if (map.pConsoles.containsKey(input) || map.sConsoles.containsKey(input) || map1.games.containsKey(input) || map1.games1.containsKey(input) || map1.games2.containsKey(input) || map1.games3.containsKey(input) || map2.psAccessories.containsKey(input) || map3.ninAccessories.containsKey(input) || map4.xAccessories.containsKey(input)) {


                    }
                }
            }
        } else if (object instanceof JTextField) {
            input = mText.getText().toUpperCase();

            if (map.sConsoles.containsKey(input)) {
                mArea.setText("There are " + map.sConsoles.get(input) + " - " + map.allconsoles.get(input) + " - " + " consoles available.");
            } else if (map1.games.containsKey(input)) {
                mArea.setText(map1.games.get(input) + " for - Playstation3 - is available.");
            } else if (map1.games1.containsKey(input)) {
                mArea.setText(map1.games1.get(input) + " for - Playstation4 - is available.");
            } else if (map1.games2.containsKey(input)) {
                mArea.setText(map1.games2.get(input) + " for - Playstation5 - is available.");
            } else if (map1.games3.containsKey(input)) {
                mArea.setText(map1.games3.get(input) + " for - PlaystationVITA - is available.");
            } else if (map2.psAccessories.containsKey(input)) {
                mArea.setText("There are " + map2.psAccessories.get(input) + "s" + " available.");
            } else if (map3.ninAccessories.containsKey(input)) {
                mArea.setText("There are " + map3.ninAccessories.get(input) + "s" + " available.");
            } else if (map4.xAccessories.containsKey(input)) {
                mArea.setText("There are " + map4.xAccessories.get(input) + "s" + " available.");
            } else {
                JOptionPane.showMessageDialog(null, "Please use an abbreviation, or that item does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
            }


        } else if (object instanceof JMenuItem) {
            JFileChooser choose = new JFileChooser();
            //choose.setMultiSelectionEnabled(true);
            //choose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            //int test = choose.showOpenDialog(null);

            choose.setCurrentDirectory(new File("iData"));
            int num = choose.showOpenDialog(null);

            if (num == 0) {
                File f = new File((choose.getSelectedFile().getPath()));
                Scanner reader = null;

                try {
                    reader = new Scanner(f);
                    if (f.isFile()) {
                        while (reader.hasNextLine()) {
                            String s = reader.nextLine() + "\n";
                            mArea.append(s);
                        }
                    }
                } catch (FileNotFoundException x) {
                    x.printStackTrace();
                    System.out.println("No file found");
                } finally {
                    assert reader != null;
                    reader.close();
                }
            }
        }
    }

}







