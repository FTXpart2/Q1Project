import java.util.Random;

public class coordPair {
    private Random rand;
    private int x,y;
    public coordPair(int xx, int yy){
        rand = new Random();
        x=xx;
        y=yy;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public String toString(){
        return "X: " + x + " Y: " + y;
    }
    public void randomize(int x, int yrange, int y){
        x = rand.nextInt(x);
        y= rand.nextInt(y-yrange+1)+y;
    }
    
}
