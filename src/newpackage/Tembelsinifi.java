
package newpackage;


public class Tembelsinifi extends Oyuncu {

    public Tembelsinifi(String oyuncuAdi, String oyuncuID, String oyuncuTur, int lokasyonx, int lokasyony, int Skor) {
        super(oyuncuAdi, oyuncuID, oyuncuTur, lokasyonx, lokasyony, Skor);
    }

    public Tembelsinifi() {
        
    }

    public int getSkor() {
        return Skor;
    }

    public void setSkor(int Skor) {
        this.Skor = Skor;
    }

    

    @Override
   public int puangoster(int dusmanlokasyonx,int dusmalokasyony,String dusmantur){
        if(dusmantur=="Gargamel"){
     if(getLokasyonx()==dusmanlokasyonx & getLokasyony() == dusmalokasyony){
     setSkor(getSkor()-15);
     }
     }
        else {
             if(getLokasyonx()==dusmanlokasyonx & getLokasyony() == dusmalokasyony){
      setSkor(getSkor()-5);
     }
        }
        
  return Skor;
  }
    
}
