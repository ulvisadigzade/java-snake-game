import java.util.Random;

public class Apple {

    public static Random random = new Random();

    public static int boardI;
    public static int boardJ;
    public static int appleI;
    public static int appleJ;
    Apple(int i,int j){
        this.boardI=i;
        this.boardJ=j;
    }

    public int genI(){
        return this.appleI = random.nextInt(1000)%(boardI-1)+1;
    }
    public int genJ(){
        return this.appleJ = random.nextInt(1000)%(boardJ-1)+1;
    }

    public boolean eaten(int i,int j){
        if(i==appleI && j==appleJ)return true;
        return false;
    }
}
