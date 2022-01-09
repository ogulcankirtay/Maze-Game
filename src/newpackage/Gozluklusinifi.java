package newpackage;

public class Gozluklusinifi extends Oyuncu {

    public Gozluklusinifi(String oyuncuAdi, String oyuncuID, String oyuncuTur, int lokasyonx, int lokasyony, int Skor) {
        super(oyuncuAdi, oyuncuID, oyuncuTur, lokasyonx, lokasyony, Skor);
    }

    public Gozluklusinifi() {

    }

    public int getSkor() {
        return Skor;
    }

    public void setSkor(int Skor) {
        this.Skor = Skor;
    }

    @Override
    public int puangoster(int dusmanlokasyonx, int dusmalokasyony, String dusmantur) {
        if (dusmantur == "Gargamel") {
            if (getLokasyonx() == dusmanlokasyonx & getLokasyony() == dusmalokasyony) {
                Skor -= 15;
            }
        } else {
            if (getLokasyonx() == dusmanlokasyonx & getLokasyony() == dusmalokasyony) {
                Skor -= 5;
            }
        }

        return Skor;
    }

}
