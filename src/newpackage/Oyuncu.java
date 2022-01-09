
package newpackage;

public class Oyuncu extends Karakter{
    int Skor;
    public Oyuncu(String oyuncuAdi, String oyuncuID, String oyuncuTur, int lokasyonx,int lokasyony,int Skor) {
        super(oyuncuAdi, oyuncuID, oyuncuTur, lokasyonx,lokasyony);
        this.Skor=Skor;
        
    }

    public Oyuncu() {
        Skor = 0;
    }

    public int getSkor() {
        return Skor;
    }

    public void setSkor(int Skor) {
        this.Skor = Skor;
    }

   

   
    


    

   
    
  public int puangoster(int dusmanlokasyonx,int dusmalokasyony,String dusmantur){
     
  return Skor;
  }
    
}


