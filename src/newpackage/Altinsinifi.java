
package newpackage;


public class Altinsinifi extends Obje{

    public Altinsinifi() {
    }

    public Altinsinifi(String objectype, int timer, int visbltytime, int price, int objLocationx, int objLocationy, int numberOfObject) {
        super(objectype, timer, visbltytime, price, objLocationx, objLocationy, numberOfObject);
    }

    public int[] getRandomx() {
        return randomx;
    }

    public void setRandomx(int[] randomx) {
        this.randomx = randomx;
    }

    public int[] getRandomy() {
        return randomy;
    }

    public void setRandomy(int[] randomy) {
        this.randomy = randomy;
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

    public int getNumberOfObject() {
        return numberOfObject;
    }

    public void setNumberOfObject(int numberOfObject) {
        this.numberOfObject = numberOfObject;
    }
    
    
}
