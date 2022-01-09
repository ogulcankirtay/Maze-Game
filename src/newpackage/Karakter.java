package newpackage;

import java.util.ArrayList;
import static newpackage.harita.Azman;
import static newpackage.harita.Gargamel;
import static newpackage.harita.Tembel;
import static newpackage.harita.matris;

public abstract class Karakter {

    private String ad;
    private String ıd;
    private String tur;
    private int lokasyonx;
    private int lokasyony;

    public Karakter(String ad, String ıd, String tur, int lokasyonx, int lokasyony) {
        this.ad = ad;
        this.ıd = ıd;
        this.tur = tur;
        this.lokasyonx = lokasyonx;
        this.lokasyony = lokasyony;
    }

    public Karakter() {
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getId() {
        return ıd;
    }

    public void setId(String ıd) {
        this.ıd = ıd;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public int getLokasyonx() {
        return lokasyonx;
    }

    public void setLokasyonx(int lokasyonx) {
        this.lokasyonx = lokasyonx;
    }

    public int getLokasyony() {
        return lokasyony;
    }

    public void setLokasyony(int lokasyony) {
        this.lokasyony = lokasyony;
    }

    

}
