package newpackage;

import java.util.ArrayList;

public class Dusman extends Karakter {
    private int baslangıcx,baslangıcy;
    public Dusman(String dusmanAdi, String dusmanID, String dusmanTür, int lokasyonx, int lokasyony) {
        super(dusmanAdi, dusmanID, dusmanTür, lokasyonx, lokasyony);

    }

    public int getBaslangıcx() {
        return baslangıcx;
    }

    public void setBaslangıcx(int baslangıcx) {
        this.baslangıcx = baslangıcx;
    }

    public int getBaslangıcy() {
        return baslangıcy;
    }

    public void setBaslangıcy(int baslangıcy) {
        this.baslangıcy = baslangıcy;
    }

    public Dusman() {
    }
public void kontrolK(Oyuncu o) {
    if(o.getLokasyonx()==getLokasyonx() && o.getLokasyony()==getLokasyony())
    {
        setLokasyonx(baslangıcx);
        setLokasyony(baslangıcy);
        
        System.out.println("aynı konum"); 
        if(getAd()=="Gargamel")
        o.setSkor(o.getSkor()-15);
        else 
            o.setSkor(o.getSkor()-5);
}
}
public char[][] yolhesapla(int[][] matris, Oyuncu o, Dusman d) {
        //djikstra
        char[][] mazeArray;
        char[][] mazeStrings = new char[matris.length][matris[0].length];
        ArrayList<Point> result = null;
        Point start = null;
        Point end = null;
        mazeArray = new char[matris.length][matris[0].length];

        for (int i = 0; i < matris.length; i++) {

            for (int j = 0; j < matris[i].length; j++) {
                if (i == o.getLokasyonx() && j == o.getLokasyony()) {
                    mazeStrings[i][j] = 'e';
                } else if (i == d.getLokasyonx() && j == d.getLokasyony()) {
                    mazeStrings[i][j] = 's';
                } else if (matris[i][j] == 0) {
                    mazeStrings[i][j] = '#';
                } else if (matris[i][j] == 1) {
                    mazeStrings[i][j] = '.';
                }

            }

        }

        for (int i = 0; i < matris.length; i++) {
            for (int j = 0; j < matris[i].length; j++) {

                {
                    mazeArray[i][j] = mazeStrings[i][j];
                }

                if (mazeArray[i][j] == MazeSolver.baslangic) {
                    start = new Point(i, j);
                }

                if (mazeArray[i][j] == MazeSolver.bitis) {
                    end = new Point(i, j);
                }

                if (mazeArray[i][j] == MazeSolver.yatayYol || mazeArray[i][j] == MazeSolver.dikeyYol) {
                    mazeArray[i][j] = MazeSolver.emptyChar;
                }
            }
        }

        result = MazeSolver.dijkstra(mazeArray, start, end);

        if (result == null) {

        } else {

            for (int i = 1; i < result.size() - 1; i++) {
                if (result.get(i - 1).a != result.get(i + 1).a && result.get(i - 1).b != result.get(i + 1).b) {
                    mazeArray[result.get(i).a][result.get(i).b] = MazeSolver.yatayYol;
                } else if (result.get(i - 1).a == result.get(i).a) {
                    mazeArray[result.get(i).a][result.get(i).b] = MazeSolver.yatayYol;
                } else if (result.get(i - 1).b == result.get(i).b) {
                    mazeArray[result.get(i).a][result.get(i).b] = MazeSolver.yatayYol;
                }
            }

        }

        return mazeArray;
    }
}