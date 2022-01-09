
package newpackage;

import java.util.Random;

public class Obje {

    int [] randomx = new int [5];
    int [] randomy = new int [5];
    String objectype;
    int timer;
    int visbltytime;
    int price;
    int objLocationx;
    int objLocationy;
    int numberOfObject;

    public Obje() {
        this.objectype = "";
        this.price = 0;
        this.timer = 0;
        this.visbltytime = 0;
        this.objLocationy = 0;
        this.objLocationx = 0;
        this.numberOfObject = 1;
    }

    public Obje(String objectype, int timer, int visbltytime, int price, int objLocationx, int objLocationy, int numberOfObject) {
        this.objectype = objectype;
        this.timer = timer;
        this.visbltytime = visbltytime;
        this.price = price;
        this.objLocationx = objLocationx;
        this.objLocationy = objLocationy;
        this.numberOfObject = numberOfObject;
    }

    public String getObjectype() {
        return objectype;
    }

    public void setObjectype(String objectype) {
        this.objectype = objectype;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public int getVisbltytime() {
        return visbltytime;
    }

    public void setVisbltytime(int visbltytime) {
        this.visbltytime = visbltytime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getObjLocationx() {
        return objLocationx;
    }

    public void setObjLocationx(int objLocationx) {
        this.objLocationx = objLocationx;
    }

    public int getObjLocationy() {
        return objLocationy;
    }

    public void setObjLocationy(int objLocationy) {
        this.objLocationy = objLocationy;
    }

    public void bekle(int waitting) throws InterruptedException {
        for (int i = waitting; i > 0; i--) {
            System.out.println("" + i);
            Thread.sleep(1000);
        }

    }

    public int getNumberOfObject() {
        return numberOfObject;
    }

    public void setNumberOfObject(int numberOfObject) {
        this.numberOfObject = numberOfObject;
    }

    public int randomlocation(Obje obj[], int matris[][]) throws InterruptedException {
        Random x = new Random();
        Random y = new Random();
//        Thread.sleep(3000);
        for (int i = 0; i < numberOfObject; i++) {
            //System.out.println("objex, objey: "+obj[i].objLocationx+obj[i].objLocationy);
            while (matris[obj[i].objLocationx][obj[i].objLocationy] == 0) {
                
                obj[i].objLocationx = x.nextInt(matris.length-2)+1;
                obj[i].objLocationy = y.nextInt(matris[0].length-2)+1;
                randomx[i] = obj[i].objLocationx;
                randomy[i] = obj[i].objLocationy;
                for (int j = 0; j < i; j++) {
                    //System.out.println("j degeri: "+j+"i degeri: "+i);
                    while ( (randomx[j]==obj[i].objLocationx) && (randomy[j]==obj[i].objLocationy) ) {
                        System.out.println("ESIT GELDI IKI ALTIN!!!");
                        obj[i].objLocationx = x.nextInt(matris.length-1)+1;
                        obj[i].objLocationy = y.nextInt(matris[0].length-1)+1;
                    }
                    
                }
    
            }
            //System.out.println("x " + obj[i].objLocationx + " y " + obj[i].objLocationy);

        }

        return 0;

    }

    
}

