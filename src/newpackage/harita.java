package newpackage;

import java.awt.Graphics;
import java.util.Random;
import java.awt.Paint;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static com.sun.tools.attach.VirtualMachine.list;
import java.awt.Color;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.Files.list;
import java.nio.file.Paths;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class harita extends javax.swing.JFrame implements KeyListener {

    int secici = 0;
    static Boolean Basildi_Mi = false;
    Boolean denetleyici = true;
    static int[][] matris = new int[11][13];
    ArrayList<Oyuncu> oyuncular = new ArrayList<Oyuncu>();
    static Oyuncu Tembel = new Tembelsinifi("Tembel", "0", "dost", 5, 6, 20);
    static Oyuncu Gozluklu = new Gozluklusinifi("Gozluklu", "1", "dost", 5, 6, 20);
    static Dusman Gargamel = new Gargamelsinifi("", "1", "dusman", 0, 0);
    static Dusman Azman = new Azmansinifi("", "1", "dusman", 0, 0);
    static Obje[] altınlar = new Altinsinifi[5];
    static Obje[] Mantar = new Mantarsinifi[1];

    JLabel ScoreTable, puan, winner, tembel, gargamel, azman, sirine, gozluklu;
    ImageIcon tmb, grg, azm, srn, gzl;
    static ImageIcon gld, mntr;
    JButton b1, b2;
    static JLabel Gold1, Gold2, Gold3, Gold4, Gold5, mantar;

    static char[][] mazeArrayA = new char[matris.length][matris[0].length];
    static char[][] mazeArrayG = new char[matris.length][matris[0].length];

    public harita() {
        oyuncular.add(Tembel);
        oyuncular.add(Gozluklu);
        this.setTitle("Sirinler Oyunu");
        this.setSize(1200, 900);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(this);
        srn = new ImageIcon("src/resim/sirine.jpg");
        tmb = new ImageIcon("src/resim/tembel.png");
        grg = new ImageIcon("src/resim/garg.png");
        azm = new ImageIcon("src/resim/azman.jpg");
        gzl = new ImageIcon("src/resim/gozluklu.png");
        gld = new ImageIcon("src/resim/gold.png");
        mntr = new ImageIcon("src/resim/mantar.png");
        gozluklu = new JLabel(gzl);
        tembel = new JLabel(tmb);
        gargamel = new JLabel(grg);
        sirine = new JLabel(srn);
        Gold1 = new JLabel(gld);
        Gold2 = new JLabel(gld);
        Gold3 = new JLabel(gld);
        Gold4 = new JLabel(gld);
        Gold5 = new JLabel(gld);
        mantar = new JLabel(mntr);
        sirine.setBounds(13 * 60, 6 * 60, 150, 150);
        azman = new JLabel(azm);
        altınlar[0] = new Altinsinifi();
        altınlar[1] = new Altinsinifi();
        altınlar[2] = new Altinsinifi();
        altınlar[3] = new Altinsinifi();
        altınlar[4] = new Altinsinifi();
        altınlar[0].setNumberOfObject(5);
        Mantar[0] = new Mantarsinifi();
        Mantar[0].setNumberOfObject(1);

        if (Gargamel.getAd() == "Gargamel") {
            gargamel.setBounds(Gargamel.getLokasyony() * 60, Gargamel.getLokasyonx() * 60, 60, 60);
        }
        if (Azman.getAd() == "Azman") {
            azman.setBounds(Azman.getLokasyony() * 60, Azman.getLokasyonx() * 60, 60, 60);
        }
        ScoreTable = new JLabel("-Skor durumu-");
        ScoreTable.setBounds(810, 1 * 60, 180, 40);
        ScoreTable.setFont(new java.awt.Font("Arial", 1, 22));
        //ScoreTable.setBackground(Color.PINK); 

        puan = new JLabel("" + Tembel.getSkor());
        puan.setBounds(880, 110, 50, 30);
        puan.setFont(new java.awt.Font("Arial", 1, 22));

        winner = new JLabel("kazandınız");
        winner.setBounds(830, 200, 200, 200);
        winner.setFont(new java.awt.Font("Arial", 1, 22));
        winner.setVisible(false);

        tembel.setOpaque(true);
        b1 = new JButton("TEMBEL");
        b2 = new JButton("GÖZLÜKLÜ");

        b1.setBounds(840, 150, 100, 100);
        b2.setBounds(950, 150, 100, 100);

        b1.setFocusable(false);
        b2.setFocusable(false);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                b1.setVisible(false);
                b2.setVisible(false);
                denetleyici = false;
                secici = 1;
                tembel.setBounds(360, 300, 60, 60);
                Basildi_Mi = true;
                repaint();

            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                b1.setVisible(false);
                denetleyici = false;
                gozluklu.setBounds(360, 300, 60, 60);
                secici = 2;
                b2.setVisible(false);
                Basildi_Mi = true;

                repaint();
            }
        });

        this.add(gozluklu);
        this.add(b1);
        this.add(b2);
        this.add(tembel);
        this.add(gargamel);
        this.add(azman);
        this.add(sirine);
        this.add(ScoreTable);
        this.add(puan);
        this.add(winner);
        this.add(Gold1);
        this.add(Gold2);
        this.add(Gold3);
        this.add(Gold4);
        this.add(Gold5);
        this.add(mantar);
        this.setVisible(true);

    }

    public void paint(Graphics g) {
        super.paint(g);
        g.translate(-53, -30);
        if (secici == 1) {
            mazeArrayA = Azman.yolhesapla(matris, Tembel, Azman);
            mazeArrayG = Gargamel.yolhesapla(matris, Tembel, Gargamel);
        }
        if (secici == 2) {
            mazeArrayA = Azman.yolhesapla(matris, Gozluklu, Azman);
            mazeArrayG = Gargamel.yolhesapla(matris, Gozluklu, Gargamel);
        }

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 13; j++) {
                Color color = null;
                Color color2 = null;
                switch (mazeArrayA[i][j]) {
                    case '#':
                        color = Color.gray;
                        break;
                    case '.':
                        color = null;
                        break;
                    case '-':
                        color = Color.red;
                        break;
                }

                if (color == null) {
                    g.setColor(color.black);
                    g.drawRect(60 * (j + 1), 60 * (i + 1), 60, 60);
                    g.setColor(color);
                    continue;
                } else if (color == Color.red) {
                    g.setColor(color);
                    g.drawRect(60 * (j + 1), 60 * (i + 1), 62, 62);
                    g.drawRect(60 * (j + 1), 60 * (i + 1), 61, 61);
                    g.drawRect(60 * (j + 1), 60 * (i + 1), 60, 60);
                    g.drawRect(60 * (j + 1), 60 * (i + 1), 59, 59);
                    g.drawRect(60 * (j + 1), 60 * (i + 1), 58, 58);
                    g.drawRect(60 * (j + 1), 60 * (i + 1), 57, 57);
                } else {
                    g.setColor(color);
                    g.fillRect(60 * (j + 1), 60 * (i + 1), 60, 60);
                    g.setColor(color.black);
                    g.drawRect(60 * (j + 1), 60 * (i + 1), 60, 60);
                }

            }

        }

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 13; j++) {

                Color color2 = null;
                switch (mazeArrayG[i][j]) {
                    case '#':
                        color2 = Color.gray;
                        break;
                    case '.':
                        color2 = null;
                        break;
                    case '-':
                        color2 = Color.RED;
                        break;
                }

                if (color2 == null) {
                    g.setColor(color2.black);
                    g.drawRect(60 * (j + 1), 60 * (i + 1), 60, 60);
                    g.setColor(color2);
                    continue;
                } else if (color2 == Color.RED) {
                    g.setColor(color2);
                    g.drawRect(60 * (j + 1), 60 * (i + 1), 62, 62);
                    g.drawRect(60 * (j + 1), 60 * (i + 1), 61, 61);
                    g.drawRect(60 * (j + 1), 60 * (i + 1), 60, 60);
                    g.drawRect(60 * (j + 1), 60 * (i + 1), 59, 59);
                    g.drawRect(60 * (j + 1), 60 * (i + 1), 58, 58);
                    g.drawRect(60 * (j + 1), 60 * (i + 1), 57, 57);
                } else {
                    g.setColor(color2);
                    g.fillRect(60 * (j + 1), 60 * (i + 1), 60, 60);
                    g.setColor(color2.black);
                    g.drawRect(60 * (j + 1), 60 * (i + 1), 60, 60);
                }

            }

        }

    }

    public static void main(String args[]) throws InterruptedException {
        int altinRandomSure, mantarRandomSure, randomfarki, saniye;
        Boolean girdimiA, girdimiM;
        Boolean ifA, ifM;
        String fileName = "src\\harita.txt";
        List<String> list = new ArrayList<>();

        int dusmansayisi = 0;
        //Dosyayı okuma ıslemını burada yapıyoruz
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            list = stream
                    .filter(line -> line.startsWith(""))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println("dosyadan okunan değerler");
        //list.forEach(System.out::println); //-> okunan tüm değerleri göstermek istersen
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).startsWith("Karakter")) {
                if (list.get(i).toUpperCase().contains("GARGAMEL")) {
                    Gargamel.setAd("Gargamel");

                    if (list.get(i).toUpperCase().endsWith("A")) {
                        Gargamel.setLokasyonx(0);
                        Gargamel.setLokasyony(3);
                        Gargamel.setBaslangıcx(0);
                        Gargamel.setBaslangıcy(3);
                        System.out.println("GARGAMEL kapı A");
                    } else if (list.get(i).toUpperCase().endsWith("B")) {

                        Gargamel.setLokasyonx(0);
                        Gargamel.setLokasyony(10);
                        Gargamel.setBaslangıcx(0);
                        Gargamel.setBaslangıcy(10);
                        System.out.println("GARGAMEL kapı B");
                    } else if (list.get(i).toUpperCase().endsWith("C")) {

                        Gargamel.setLokasyonx(5);
                        Gargamel.setLokasyony(0);
                        Gargamel.setBaslangıcx(5);
                        Gargamel.setBaslangıcy(0);
                        System.out.println(" GARGAMEL kapı C");
                    } else if (list.get(i).toUpperCase().endsWith("D")) {

                        Gargamel.setLokasyonx(10);
                        Gargamel.setLokasyony(3);
                        System.out.println(" Gargamel kapı D");
                        Gargamel.setBaslangıcx(10);
                        Gargamel.setBaslangıcy(3);
                    }
                }
                if (list.get(i).toUpperCase().contains("AZMAN")) {
                    Azman.setAd("Azman");
                    if (list.get(i).toUpperCase().endsWith("A")) {
                        Azman.setLokasyonx(0);
                        Azman.setLokasyony(3);
                        Azman.setBaslangıcx(0);
                        Azman.setBaslangıcy(3);
                        System.out.println("AZMAN kapı A");
                    } else if (list.get(i).toUpperCase().endsWith("B")) {
                        Azman.setLokasyonx(0);
                        Azman.setLokasyony(10);
                        Azman.setBaslangıcx(0);
                        Azman.setBaslangıcy(10);
                        System.out.println("AZMAN kapı B");
                    } else if (list.get(i).toUpperCase().endsWith("C")) {
                        Azman.setLokasyonx(5);
                        Azman.setLokasyony(0);
                        Azman.setBaslangıcx(5);
                        Azman.setBaslangıcy(0);
                        System.out.println(" AZMAN kapı C");
                    } else if (list.get(i).toUpperCase().endsWith("D")) {
                        Azman.setLokasyonx(10);
                        Azman.setLokasyony(3);
                        Azman.setBaslangıcx(10);
                        Azman.setBaslangıcy(3);
                        System.out.println(" AZMAN kapı D");
                    }
                }
                dusmansayisi += 1;
            }

        }

        int x = 0;
        for (int i = dusmansayisi; i < list.size(); i++, x++) {
            int y = 0;
            for (int j = 0; j < list.get(i).length(); j++) {
                if (j % 2 != 1) {
                    String a = "" + list.get(i).charAt(j);
                    int b = Integer.valueOf(a);

                    matris[x][y] = b;

                    System.out.print("" + matris[x][y]);
                    y++;
                }

            }
            System.out.println("");
        }

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                new harita().setVisible(true);

            }

        }
        );
        Thread.sleep(100);
        while (Basildi_Mi == false) { // Karakter secimi yapilincaya kadar uyutur.
            Thread.sleep(100);
        }

        for (int g = 0; g < 1; g++) {
            Random r1 = new Random();
            Random r2 = new Random();
            altinRandomSure = r1.nextInt(10) + 1;
            mantarRandomSure = r2.nextInt(20) + 1;

            girdimiA = false;
            girdimiM = false;
            ifA = false;
            ifM = false;

            if (mantarRandomSure + 7 > altinRandomSure + 5) {
                saniye = mantarRandomSure + 7;
            } else {
                saniye = altinRandomSure + 5;
            }

            System.out.println("altin,mantar: " + altinRandomSure + " " + mantarRandomSure);

            for (int i = 1; i < saniye + 1; i++) {
                Thread.sleep(1000);
                System.out.println(i + ". saniye");
                if (i == altinRandomSure) {
                    girdimiA = true;
                    System.out.println(altinRandomSure + " saniye boyunca beklenildi. altin");
                    altınlar[0].randomlocation(altınlar, matris);
                    Gold1.setBounds(altınlar[0].getObjLocationy() * 60, 60 * altınlar[0].getObjLocationx(), 60, 60);
                    Gold2.setBounds(altınlar[1].getObjLocationy() * 60, 60 * altınlar[1].getObjLocationx(), 60, 60);
                    Gold3.setBounds(altınlar[2].getObjLocationy() * 60, 60 * altınlar[2].getObjLocationx(), 60, 60);
                    Gold4.setBounds(altınlar[3].getObjLocationy() * 60, 60 * altınlar[3].getObjLocationx(), 60, 60);
                    Gold5.setBounds(altınlar[4].getObjLocationy() * 60, 60 * altınlar[4].getObjLocationx(), 60, 60);
                    Gold1.setIcon(gld);
                    Gold2.setIcon(gld);
                    Gold3.setIcon(gld);
                    Gold4.setIcon(gld);
                    Gold5.setIcon(gld);

                }
                if (i == mantarRandomSure) {
                    girdimiM = true;
                    System.out.println(mantarRandomSure + " saniye boyunca beklenildi. mantar");
                    Mantar[0].randomlocation(Mantar, matris);
                    mantar.setBounds(Mantar[0].getObjLocationy() * 60, 60 * Mantar[0].getObjLocationx(), 60, 60);
                    mantar.setIcon(mntr);
                }
                if (ifA == false && girdimiA == true && i == altinRandomSure + 5) {
                    ifA = true;
                    for (int a = 0; a < 5; a++) {
                        altınlar[a].setObjLocationy(0);
                        altınlar[a].setObjLocationx(0);
                    }
                    Gold1.setIcon(null);
                    Gold2.setIcon(null);
                    Gold3.setIcon(null);
                    Gold4.setIcon(null);
                    Gold5.setIcon(null);
                }

                if (ifM == false && girdimiM == true && i == mantarRandomSure + 7) {
                    ifM = true;
                    //Thread.sleep(7000);
                    Mantar[0].setObjLocationy(0);
                    Mantar[0].setObjLocationx(0);
                    mantar.setIcon(null);
                }

            }
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (denetleyici == false) {
            switch (e.getKeyCode()) {
                case 37:
                    if (secici == 1) {
                        if ((matris[Tembel.getLokasyonx()][Tembel.getLokasyony() - 1]) == 1) {
                            tembel.setLocation(tembel.getX() - 60, tembel.getY()); //sola
                            Tembel.setLokasyony(Tembel.getLokasyony() - 1);

                            for (int i = 0; i < 5; i++) {
                                if (Tembel.getLokasyonx() == altınlar[i].getObjLocationx() & Tembel.getLokasyony() == altınlar[i].getObjLocationy()) {
                                    Tembel.setSkor(Tembel.getSkor() + 5);
                                    puan.setText("" + Tembel.getSkor());
                                    altınlar[i].setObjLocationy(0);
                                    altınlar[i].setObjLocationx(0);

                                    switch (i) {
                                        case 0:
                                            Gold1.setVisible(false);
                                            break;
                                        case 1:
                                            Gold2.setVisible(false);
                                            break;
                                        case 2:
                                            Gold3.setVisible(false);
                                            break;
                                        case 3:
                                            Gold4.setVisible(false);
                                            break;
                                        case 4:
                                            Gold5.setVisible(false);
                                            break;
                                    }
                                }
                            }
                            if (Tembel.getLokasyonx() == Mantar[0].getObjLocationx() & Tembel.getLokasyony() == Mantar[0].getObjLocationy()) {
                                Tembel.setSkor(Tembel.getSkor() + 50);
                                puan.setText("" + Tembel.getSkor());
                                Mantar[0].setObjLocationy(0);
                                Mantar[0].setObjLocationx(0);
                                mantar.setVisible(false);
                            }
                        }
                    } else if (secici == 2) {
                        if ((matris[Gozluklu.getLokasyonx()][Gozluklu.getLokasyony() - 2]) == 1
                                && (matris[Gozluklu.getLokasyonx()][Gozluklu.getLokasyony() - 1]) == 1) {
                            gozluklu.setLocation(gozluklu.getX() - 120, gozluklu.getY()); //sola
                            Gozluklu.setLokasyony(Gozluklu.getLokasyony() - 2);
                            for (int i = 0; i < 5; i++) {
                                if (Gozluklu.getLokasyonx() == altınlar[i].getObjLocationx() & Gozluklu.getLokasyony() == altınlar[i].getObjLocationy()) {
                                    Gozluklu.setSkor(Gozluklu.getSkor() + 5);
                                    puan.setText("" + Gozluklu.getSkor());
                                    altınlar[i].setObjLocationy(0);
                                    altınlar[i].setObjLocationx(0);
                                    switch (i) {
                                        case 0:
                                            Gold1.setVisible(false);
                                            break;
                                        case 1:
                                            Gold2.setVisible(false);
                                            break;
                                        case 2:
                                            Gold3.setVisible(false);
                                            break;
                                        case 3:
                                            Gold4.setVisible(false);
                                            break;
                                        case 4:
                                            Gold5.setVisible(false);
                                            break;
                                    }
                                }
                            }
                            if (Gozluklu.getLokasyonx() == Mantar[0].getObjLocationx() & Gozluklu.getLokasyony() == Mantar[0].getObjLocationy()) {
                                Gozluklu.setSkor(Gozluklu.getSkor() + 50);
                                puan.setText("" + Gozluklu.getSkor());
                                Mantar[0].setObjLocationy(0);
                                Mantar[0].setObjLocationx(0);
                                mantar.setVisible(false);
                            }

                        }
                    }
                    break;
                case 38:
                    if (secici == 1) {
                        if ((matris[Tembel.getLokasyonx() - 1][Tembel.getLokasyony()]) == 1) {
                            tembel.setLocation(tembel.getX(), tembel.getY() - 60); // yukari
                            Tembel.setLokasyonx(Tembel.getLokasyonx() - 1);
                            for (int i = 0; i < 5; i++) {

                                if (Tembel.getLokasyonx() == altınlar[i].getObjLocationx() & Tembel.getLokasyony() == altınlar[i].getObjLocationy()) {
                                    Tembel.setSkor(Tembel.getSkor() + 5);
                                    puan.setText("" + Tembel.getSkor());
                                    altınlar[i].setObjLocationy(0);
                                    altınlar[i].setObjLocationx(0);
                                    switch (i) {
                                        case 0:
                                            Gold1.setVisible(false);
                                            break;
                                        case 1:
                                            Gold2.setVisible(false);
                                            break;
                                        case 2:
                                            Gold3.setVisible(false);
                                            break;
                                        case 3:
                                            Gold4.setVisible(false);
                                            break;
                                        case 4:
                                            Gold5.setVisible(false);
                                            break;
                                    }
                                }
                            }
                            if (Tembel.getLokasyonx() == Mantar[0].getObjLocationx() & Tembel.getLokasyony() == Mantar[0].getObjLocationy()) {
                                Tembel.setSkor(Tembel.getSkor() + 50);
                                puan.setText("" + Tembel.getSkor());
                                Mantar[0].setObjLocationy(0);
                                Mantar[0].setObjLocationx(0);
                                mantar.setVisible(false);
                            }
                        }
                    } else if (secici == 2) {
                        if ((matris[Gozluklu.getLokasyonx() - 2][Gozluklu.getLokasyony()]) == 1
                                && (matris[Gozluklu.getLokasyonx() - 1][Gozluklu.getLokasyony()]) == 1) {
                            gozluklu.setLocation(gozluklu.getX(), gozluklu.getY() - 120); // yukari
                            Gozluklu.setLokasyonx(Gozluklu.getLokasyonx() - 2);
                            for (int i = 0; i < 5; i++) {
                                if (Gozluklu.getLokasyonx() == altınlar[i].getObjLocationx() & Gozluklu.getLokasyony() == altınlar[i].getObjLocationy()) {
                                    Gozluklu.setSkor(Gozluklu.getSkor() + 5);
                                    puan.setText("" + Gozluklu.getSkor());
                                    altınlar[i].setObjLocationy(0);
                                    altınlar[i].setObjLocationx(0);
                                    switch (i) {
                                        case 0:
                                            Gold1.setVisible(false);
                                            break;
                                        case 1:
                                            Gold2.setVisible(false);
                                            break;
                                        case 2:
                                            Gold3.setVisible(false);
                                            break;
                                        case 3:
                                            Gold4.setVisible(false);
                                            break;
                                        case 4:
                                            Gold5.setVisible(false);
                                            break;
                                    }
                                }
                            }
                            if (Gozluklu.getLokasyonx() == Mantar[0].getObjLocationx() & Gozluklu.getLokasyony() == Mantar[0].getObjLocationy()) {
                                Gozluklu.setSkor(Gozluklu.getSkor() + 50);
                                puan.setText("" + Gozluklu.getSkor());
                                Mantar[0].setObjLocationy(0);
                                Mantar[0].setObjLocationx(0);
                                mantar.setVisible(false);
                            }
                        }
                    }

                    break;
                case 39:
                    if (secici == 1) {
                        if ((matris[Tembel.getLokasyonx()][Tembel.getLokasyony() + 1]) == 1) {
                            tembel.setLocation(tembel.getX() + 60, tembel.getY()); // saga
                            Tembel.setLokasyony(Tembel.getLokasyony() + 1);
                            if (Tembel.getLokasyonx() == 7 && Tembel.getLokasyony() == 12) {
                                winner.setVisible(true);
                                JOptionPane.showMessageDialog(null, "KAZANDINIZ!", "Tebrikler", JOptionPane.INFORMATION_MESSAGE);
                                repaint();
                                System.exit(0);
                            }
                            for (int i = 0; i < 5; i++) {

                                if (Tembel.getLokasyonx() == altınlar[i].getObjLocationx() & Tembel.getLokasyony() == altınlar[i].getObjLocationy()) {
                                    Tembel.setSkor(Tembel.getSkor() + 5);
                                    puan.setText("" + Tembel.getSkor());
                                    altınlar[i].setObjLocationy(0);
                                    altınlar[i].setObjLocationx(0);
                                    switch (i) {
                                        case 0:
                                            Gold1.setVisible(false);
                                            break;
                                        case 1:
                                            Gold2.setVisible(false);
                                            break;
                                        case 2:
                                            Gold3.setVisible(false);
                                            break;
                                        case 3:
                                            Gold4.setVisible(false);
                                            break;
                                        case 4:
                                            Gold5.setVisible(false);
                                            break;
                                    }
                                }
                            }
                            if (Tembel.getLokasyonx() == Mantar[0].getObjLocationx() & Tembel.getLokasyony() == Mantar[0].getObjLocationy()) {
                                Tembel.setSkor(Tembel.getSkor() + 50);
                                puan.setText("" + Tembel.getSkor());
                                Mantar[0].setObjLocationy(0);
                                Mantar[0].setObjLocationx(0);
                                mantar.setVisible(false);
                            }
                        }
                    } else if (secici == 2) {
                        if ((matris[Gozluklu.getLokasyonx()][Gozluklu.getLokasyony() + 2]) == 1
                                && (matris[Gozluklu.getLokasyonx()][Gozluklu.getLokasyony() + 1]) == 1) {
                            gozluklu.setLocation(gozluklu.getX() + 120, gozluklu.getY()); // saga
                            Gozluklu.setLokasyony(Gozluklu.getLokasyony() + 2);

                            if (Gozluklu.getLokasyonx() == 7 && Gozluklu.getLokasyony() == 12) {
                                winner.setVisible(true);
                                JOptionPane.showMessageDialog(null, "KAZANDINIZ!", "Tebrikler", JOptionPane.INFORMATION_MESSAGE);
                                repaint();
                                System.exit(0);

                            }
                            for (int i = 0; i < 5; i++) {
                                if (Gozluklu.getLokasyonx() == altınlar[i].getObjLocationx() & Gozluklu.getLokasyony() == altınlar[i].getObjLocationy()) {
                                    Gozluklu.setSkor(Gozluklu.getSkor() + 5);
                                    puan.setText("" + Gozluklu.getSkor());
                                    altınlar[i].setObjLocationy(0);
                                    altınlar[i].setObjLocationx(0);
                                    switch (i) {
                                        case 0:
                                            Gold1.setVisible(false);
                                            break;
                                        case 1:
                                            Gold2.setVisible(false);
                                            break;
                                        case 2:
                                            Gold3.setVisible(false);
                                            break;
                                        case 3:
                                            Gold4.setVisible(false);
                                            break;
                                        case 4:
                                            Gold5.setVisible(false);
                                            break;
                                    }
                                }
                            }
                            if (Gozluklu.getLokasyonx() == Mantar[0].getObjLocationx() & Gozluklu.getLokasyony() == Mantar[0].getObjLocationy()) {
                                Gozluklu.setSkor(Gozluklu.getSkor() + 50);
                                puan.setText("" + Gozluklu.getSkor());
                                Mantar[0].setObjLocationy(0);
                                Mantar[0].setObjLocationx(0);
                                mantar.setVisible(false);
                            }
                        }
                    }

                    break;
                case 40:
                    if (secici == 1) {
                        if ((matris[Tembel.getLokasyonx() + 1][Tembel.getLokasyony()]) == 1) {
                            tembel.setLocation(tembel.getX(), tembel.getY() + 60); // asagi
                            Tembel.setLokasyonx(Tembel.getLokasyonx() + 1);
                            for (int i = 0; i < 5; i++) {

                                if (Tembel.getLokasyonx() == altınlar[i].getObjLocationx() & Tembel.getLokasyony() == altınlar[i].getObjLocationy()) {
                                    Tembel.setSkor(Tembel.getSkor() + 5);
                                    puan.setText("" + Tembel.getSkor());
                                    altınlar[i].setObjLocationy(0);
                                    altınlar[i].setObjLocationx(0);
                                    switch (i) {
                                        case 0:
                                            Gold1.setVisible(false);
                                            break;
                                        case 1:
                                            Gold2.setVisible(false);
                                            break;
                                        case 2:
                                            Gold3.setVisible(false);
                                            break;
                                        case 3:
                                            Gold4.setVisible(false);
                                            break;
                                        case 4:
                                            Gold5.setVisible(false);
                                            break;
                                    }
                                }
                            }
                            if (Tembel.getLokasyonx() == Mantar[0].getObjLocationx() & Tembel.getLokasyony() == Mantar[0].getObjLocationy()) {
                                Tembel.setSkor(Tembel.getSkor() + 50);
                                puan.setText("" + Tembel.getSkor());
                                Mantar[0].setObjLocationy(0);
                                Mantar[0].setObjLocationx(0);
                                mantar.setVisible(false);
                            }
                        }

                    } else if (secici == 2) {
                        if ((matris[Gozluklu.getLokasyonx() + 2][Gozluklu.getLokasyony()]) == 1
                                && (matris[Gozluklu.getLokasyonx() + 1][Gozluklu.getLokasyony()]) == 1) {
                            gozluklu.setLocation(gozluklu.getX(), gozluklu.getY() + 120); // asagi
                            Gozluklu.setLokasyonx(Gozluklu.getLokasyonx() + 2);
                            for (int i = 0; i < 5; i++) {
                                if (Gozluklu.getLokasyonx() == altınlar[i].getObjLocationx() & Gozluklu.getLokasyony() == altınlar[i].getObjLocationy()) {
                                    Gozluklu.setSkor(Gozluklu.getSkor() + 5);
                                    puan.setText("" + Gozluklu.getSkor());
                                    altınlar[i].setObjLocationy(0);
                                    altınlar[i].setObjLocationx(0);
                                    switch (i) {
                                        case 0:
                                            Gold1.setVisible(false);
                                            break;
                                        case 1:
                                            Gold2.setVisible(false);
                                            break;
                                        case 2:
                                            Gold3.setVisible(false);
                                            break;
                                        case 3:
                                            Gold4.setVisible(false);
                                            break;
                                        case 4:
                                            Gold5.setVisible(false);
                                            break;
                                    }
                                }
                            }
                            if (Gozluklu.getLokasyonx() == Mantar[0].getObjLocationx() & Gozluklu.getLokasyony() == Mantar[0].getObjLocationy()) {
                                Gozluklu.setSkor(Gozluklu.getSkor() + 50);
                                puan.setText("" + Gozluklu.getSkor());
                                Mantar[0].setObjLocationy(0);
                                Mantar[0].setObjLocationx(0);
                                mantar.setVisible(false);
                            }
                        }
                    }
                    break;
            }
            if(secici==1)
            { mazeArrayG=Gargamel.yolhesapla(matris, Tembel,Gargamel);}
            else if(secici==2)
            {mazeArrayG=Gargamel.yolhesapla(matris, Gozluklu,Gargamel);
            
            }}
            // gargamel kontrol
            for (int i = 0; i < 2; i++) {
                int a=0;
                if (a==0 & mazeArrayG[Gargamel.getLokasyonx()][Gargamel.getLokasyony() + 1] == '-' | (mazeArrayG[Gargamel.getLokasyonx()][Gargamel.getLokasyony() + 1] == 'e')) {
                    Gargamel.setLokasyony(Gargamel.getLokasyony() + 1);
                    gargamel.setLocation(Gargamel.getLokasyony() * 60, Gargamel.getLokasyonx() * 60);
                 
                a++;
                }
                if (a==0 &(Gargamel.getLokasyonx() != 0)) {
                    if (mazeArrayG[Gargamel.getLokasyonx() - 1][Gargamel.getLokasyony()] == '-' | (mazeArrayG[Gargamel.getLokasyonx() - 1][Gargamel.getLokasyony()] == 'e')) {

                        Gargamel.setLokasyonx(Gargamel.getLokasyonx() - 1);
                        gargamel.setLocation(Gargamel.getLokasyony() * 60, Gargamel.getLokasyonx() * 60);
                       
                    a++;
                    }
                }

                if (a==0 &(Gargamel.getLokasyonx() != mazeArrayG.length - 1)) {

                    if (mazeArrayG[Gargamel.getLokasyonx() + 1][Gargamel.getLokasyony()] == '-' | (mazeArrayG[Gargamel.getLokasyonx() + 1][Gargamel.getLokasyony()] == 'e')) {
                        Gargamel.setLokasyonx(Gargamel.getLokasyonx() + 1);
                        gargamel.setLocation(Gargamel.getLokasyony() * 60, Gargamel.getLokasyonx() * 60);
                  
                    a++;
                    }
                }
                if (a==0 &(Gargamel.getLokasyony() != 0)) {
                    if (mazeArrayG[Gargamel.getLokasyonx()][Gargamel.getLokasyony() - 1] == '-' | (mazeArrayG[Gargamel.getLokasyonx()][Gargamel.getLokasyony() - 1] == 'e')) {
                        Gargamel.setLokasyony(Gargamel.getLokasyony() - 1);
                        gargamel.setLocation(Gargamel.getLokasyony() * 60, Gargamel.getLokasyonx() * 60);
                     
                        a++;
                    }
                
                }
            

            //azman kontrol
            if (mazeArrayA[Azman.getLokasyonx()][Azman.getLokasyony() + 1] == '-' & !(Azman.getLokasyonx() == Gargamel.getLokasyonx() & Azman.getLokasyony() + 1 == Gargamel.getLokasyony())) {
                Azman.setLokasyony(Azman.getLokasyony() + 1);
                azman.setLocation(Azman.getLokasyony() * 60, Azman.getLokasyonx() * 60);
            }
            if ((Azman.getLokasyonx() != 0)) {
                if (mazeArrayA[Azman.getLokasyonx() - 1][Azman.getLokasyony()] == '-' & !(Azman.getLokasyonx() - 1 == Gargamel.getLokasyonx() & Azman.getLokasyony() == Gargamel.getLokasyony())) {
                    Azman.setLokasyonx(Azman.getLokasyonx() - 1);
                    azman.setLocation(Azman.getLokasyony() * 60, Azman.getLokasyonx() * 60);
                }
            }

            if (Azman.getLokasyonx() != mazeArrayA.length - 1) {
                if (mazeArrayA[Azman.getLokasyonx() + 1][Azman.getLokasyony()] == '-' & !(Azman.getLokasyonx() + 1 == Gargamel.getLokasyonx() & Azman.getLokasyony() == Gargamel.getLokasyony())) {
                    Azman.setLokasyonx(Azman.getLokasyonx() + 1);
                    azman.setLocation(Azman.getLokasyony() * 60, Azman.getLokasyonx() * 60);
                }
            }
            if ((Azman.getLokasyony() != 0)) {
                if (mazeArrayA[Azman.getLokasyonx()][Azman.getLokasyony() - 1] == '-' & !(Azman.getLokasyonx() == Gargamel.getLokasyonx() & Azman.getLokasyony() - 1 == Gargamel.getLokasyony())) {
                    Azman.setLokasyony(Azman.getLokasyony() - 1);
                    azman.setLocation(Azman.getLokasyony() * 60, Azman.getLokasyonx() * 60);
                }
            }

            if (secici == 1) {

                Gargamel.kontrolK(Tembel);
                Azman.kontrolK(Tembel);

                puan.setText("" + Tembel.getSkor());

                gargamel.setLocation(60 * Gargamel.getLokasyony(), 60 * Gargamel.getLokasyonx());
                azman.setLocation(60 * Azman.getLokasyony(), 60 * Azman.getLokasyonx());
                if (Tembel.getSkor() <= 0) {
                    JOptionPane.showMessageDialog(null, "KAYBETTİNİZ", "Puan 0'ın altına düştü", JOptionPane.INFORMATION_MESSAGE);
                    repaint();
                    System.exit(0);
                }
            } else if (secici == 2) {
                Gargamel.kontrolK(Gozluklu);
                Azman.kontrolK(Gozluklu);
                puan.setText("" + Gozluklu.getSkor());

                gargamel.setLocation(60 * Gargamel.getLokasyony(), 60 * Gargamel.getLokasyonx());
                azman.setLocation(60 * Azman.getLokasyony(), 60 * Azman.getLokasyonx());
                if (Gozluklu.getSkor() <= 0) {
                    JOptionPane.showMessageDialog(null, "KAYBETTİNİZ", "Puan 0'ın altına düştü", JOptionPane.INFORMATION_MESSAGE);
                    repaint();
                    System.exit(0);
                }
            }

            repaint();
        }

    }

}