import java.util.ArrayList;

public class Game {
    public static int boardI=20;
    public static int boardJ=40;
    public static int dirI=0,dirJ=-1;
    public static int [][] board = new int[boardI][boardJ];
    public static ArrayList<int[]> Snake = new ArrayList<>();

    static GameInput TakeInput = new GameInput();
    static Apple apple = new Apple(boardI,boardJ);
    public static int appleI = apple.genI();
    public static int appleJ = apple.genJ();
    public static boolean isRunning = true;

    public static char prevButton='a';
    public static void start(){
        Snake.add(new int[]{boardI/2, boardJ/2});
        Snake.add(new int[]{boardI/2, boardJ/2+1});
        while(isRunning){
            clr();
            printBoard();
            makeMove();
            wait(200);
        }
    }
    public static void makeMove(){
        char ch = TakeInput.getChar();
        if(ch=='w' && prevButton!='s'){
            dirI=-1;
            dirJ=0;
            prevButton=ch;
        }
        else if(ch=='a' && prevButton!='d'){
            dirI=0;
            dirJ=-1;
            prevButton=ch;
        }
        else if(ch=='s' && prevButton!='w'){
            dirI=1;
            dirJ=0;
            prevButton=ch;
        }
        else if(ch=='d' && prevButton!='a'){
            dirI=0;
            dirJ=1;
            prevButton=ch;
        }


        for(int i=Snake.size()-1;i>0;i--){
            var elem1 = Snake.get(i-1);
            Snake.set(i,elem1);
        }
        var elem = Snake.get(0);
        int newi = elem[0]+dirI;
        int newj = elem[1]+dirJ;
        Snake.set(0,new int[]{newi,newj});


        if(lose()){
            isRunning=false;
        }else{
            if(apple.eaten(newi,newj)){
                appleI = apple.genI();
                appleJ = apple.genJ();
                addtail(prevButton);
            }
        }
    }
    public static void addtail(char btn){
        var elem = Snake.get(Snake.size()-1);

        if(btn=='w'){
            Snake.add(new int[]{elem[0]+1,elem[1]});
        }
        else if(btn=='s'){
            Snake.add(new int[]{elem[0]-1,elem[1]});
        }
        else if(btn=='a'){
            Snake.add(new int[]{elem[0],elem[1]+1});
        }
        else if(btn=='d'){
            Snake.add(new int[]{elem[0],elem[1]-1});
        }
    }
    public static boolean lose(){
        var elem = Snake.get(0);

        if(elem[1]==0 || elem[1]==boardJ-1 || elem[0]==0 || elem[0]==boardI-1){
            return true;
        }
        for(int i=1;i<Snake.size();i++){
            var elem1 = Snake.get(i);
            if(elem[0]==elem1[0] && elem[1]==elem1[1]){
                return true;
            }
        }
        return false;
    }
    public static void printBoard(){
        for(int i=0;i<boardI;i++){
            for(int j=0;j<boardJ;j++){
                if(contains(i,j)) System.out.print("O");
                else if(i==appleI && j==appleJ) System.out.print('X');
                else if(i==0 || i==boardI-1 || j==0 || j==boardJ-1)System.out.print("#");
                else System.out.print(" ");

            }
            System.out.println();
        }
    }
    public static boolean contains(int i,int j){
        for(int [] k:Snake){
            if(k[0]==i && k[1]==j)return true;
        }
        return false;
    }
    public static void clr(){
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void wait(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
