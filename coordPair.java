import java.io.Serializable;
import java.util.Random;

public class coordPair implements Serializable {
    private static final long serialVersionUID = 1L;
    private Random rand;
    private int x,y;
    public coordPair(int xx, int yy){
        rand = new Random();
        x=xx;
        y=yy;
    }

    //returnx
    public int getX(){
        return x;
    }
    //returny
    public int getY(){
        return y;
    }
    public String toString(){
        return "X: " + x + " Y: " + y;
    }
    //randomizes the coordinates
    public void randomize(int xz, int yrange, int yz){
        x = rand.nextInt(xz);
        y = rand.nextInt(yz-yrange+1)+yz;
    }
    
}
